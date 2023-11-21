package test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author prakashponali
 * @Date 09/10/23
 */
public class Java8Improvements {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) list.add(i);

        list.forEach(System.out::println);

        for (Integer integer : list) {
            System.out.println(integer);
        }
        list.forEach(integer -> System.out.println("This is from anonymous class " + integer));

        Myconsumer myconsumer = new Myconsumer();
        list.forEach(myconsumer);

    }

    public static class Myconsumer implements Consumer<Integer>{


        @Override
        public void accept(final Integer integer) {

            System.out.println("This is from separate class " + integer);

        }
    }
}
