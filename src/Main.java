import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList();
        a.add(3);
        //a.add(1);
        //a.add(10);

        List<Integer> b = new ArrayList();
        b.add(3);
        b.add(3);
        b.add(2);

        List<Integer> c = new ArrayList();
        c.add(3);
        c.add(3);
        c.add(2);
        c.add(333);

        List<Integer> d = new ArrayList();
        d.add(3);
        d.add(3);
        d.add(2);
        d.add(6);


        List<Integer> e = new ArrayList();
        e.add(3);
        e.add(3);
        e.add(2);
        e.add(8);

        List<Integer> f = new ArrayList<>();
        f.add(0);
        f.add(9);
        f.add(3);
        f.add(10);
        f.add(2);
        f.add(20);


        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(a);
        matrix.add(b);
        matrix.add(c);
        matrix.add(d);
        //matrix.add(e);
        //matrix.add(f);

        //System.out.println(Main.compareTriplets(a, b));

        //System.out.println(Main.diagonalDifference(matrix));
        System.out.println(Main.breakingRecords(f));



    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int bob = 0;
        int alice = 0;

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                bob = ++bob;
            } else if(a.get(i) < b.get(i)) {
                alice = ++alice;
            }
        }

        return new ArrayList<>(Arrays.asList(bob, alice));

    }


    public static int diagonalDifference(List<List<Integer>> arr) {

        //int diagonalDifferece = 0;
        int previousIndex = 0;
        int lenghtOfMatrix = 1;
        //List<List<Integer>> martix = new ArrayList<ArrayList<Integer>()>();
        for(int i = 0; i < arr.size(); i++){

                if(arr.get(i).size() == arr.get(previousIndex).size()){
                    lenghtOfMatrix= lenghtOfMatrix+1;
                } else {
                    previousIndex = i;
                    lenghtOfMatrix = 1;
                }


        }
        int diagonalDifference = 0;
        int otherdia= 0;
        for(int i = 0; i < lenghtOfMatrix ; i++){
            List<Integer> row = arr.get(previousIndex);
            previousIndex =  previousIndex + 1;

            for(int j = 0; j <  row.size(); i++) {
                if(j==i) {
                    diagonalDifference = diagonalDifference + row.get(j);
                }
                if(j+i == 0){
                    otherdia = otherdia + row.get(j);
                }
            }

        }
        System.out.println("lenghtOfMatrix  " + lenghtOfMatrix + "   previousIndex " + previousIndex);
        return diagonalDifference- otherdia;

    }


    public static void plusMinus(List<Integer> arr) {
        int positive = 0;

        String as = "asdfasdf";
        int negetive = 0;
        int zero = 0;
        for(int i= 0; i < arr.size(); i++) {
            if(arr.get(i) > 0) {
                positive = ++positive;
            } else if(arr.get(i) < 0) {
                negetive = ++negetive;
            }  else{
                zero = ++zero;
            }
        }
        NumberFormat df = new DecimalFormat("0.000000");
        df.setRoundingMode(RoundingMode.FLOOR);
        df.setMaximumFractionDigits(6);
        double newvluae= 0D;
        if(positive> 0) {
            newvluae = (float)positive / arr.size();
            System.out.println(df.format(newvluae));
        }else{
            System.out.println(df.format(0D));
        }
        if(negetive>=0) {
            newvluae = (float)negetive / arr.size();
            System.out.println(df.format(newvluae));
        }else{
            System.out.println(df.format(0D));
        }
        if(zero > 0) {
            newvluae = (float)zero / arr.size();
            System.out.println(df.format(newvluae));
        }else{
            System.out.println(df.format(0D));
        }

        List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        double min = 0;
        double max = 0;
        for (int i=0; i< sorted.size();i++) {
            if(i < 4) {
                min = min + sorted.get(i);
            }
            if(i > 0) {
                max = max + sorted.get(i);
            }
        }
        System.out.println(min + " " + max);
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minimum = 0;
        int maximum = 0;
        int minCount = 0;
        int maxCount = 0;

        for(int i = 0; i < scores.size(); i++) {
            if(i == 0) {
                minimum = scores.get(i);
                maximum = scores.get(i);
            }
            if(minimum > scores.get(i)) {
                minimum = scores.get(i);
                ++minCount;
            }
            if(maximum < scores.get(i)) {
                maximum = scores.get(i);
                ++maxCount;
            }
        }
        List<Integer> finalList = new ArrayList<Integer>();
        finalList.add(maxCount);
        finalList.add(minCount);
        return finalList;
    }


}