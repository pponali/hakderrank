package test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prakashponali
 * @Date 10/10/23
 */
public class TestStream {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("prakash");
        stringList.add("prakash");
        stringList.add("jayasri");
        stringList.add("tejas");
        stringList.add("charan");

        System.out.println(stringList
                .stream().filter(s -> s.equals("prakash"))
                .collect(Collectors.toList()));

        System.out.println(stringList
                .stream().peek((s) -> s.equals("tejas")));
                //.collect(Collectors.toList()));
        System.out.println(stringList.
                stream().distinct()
                .collect(Collectors.toList()));

        System.out.println(stringList.
                stream().map(x -> x + " ponali")
                .collect(Collectors.toList()));

        System.out.println(stringList.
                stream().distinct()
                .collect(Collectors.toList()));
        System.out.println(stringList.
                stream().peek(p -> {
                    p = p.concat(" Ponali");
                })
                .collect(Collectors.toSet()));


        // intermediate operations

        System.out.println(stringList.
                stream().peek(p -> {
                    p = p.concat(" Ponali");
                })
                .collect(Collectors.toSet()));
        System.out.println(stringList.stream().distinct().collect(Collectors.toList()));
        System.out.println(stringList.stream().limit(4).collect(Collectors.toList()));

        System.out.println(stringList.stream().filter(s -> s.equals("tejas")).collect(Collectors.toList()));

        System.out.println(stringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));


    }
}
