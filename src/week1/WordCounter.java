package week1;

import java.util.*;

/**
 * @author prakashponali
 * @Date 14/10/23
 */
public class WordCounter {

    public static void main(String[] args) {

        String input = "Prakash is employee of Jio company, PRAKASH is from Bangalore, PRAKASH! is good in java.";
        String regex = "[^a-zA-Z0-9 ]";
        input = input.replaceAll(regex ,"");
        System.out.println(getCounter(input));


    }

   public static Map<Word, Integer> getCounter(final String input){

        Map<Word, Integer> validator = new HashMap<>();

       wordCounter(input, validator);



       List<Integer> values =  validator.values().stream().toList();
        Integer Max = 0;
        for(Integer value : values){
            Max = Math.max(Max, value);
        }
        Map<Word, Integer> wordsToBeReturned = new HashMap<>();
       for(Word word: validator.keySet()){
           if((int) validator.get(word) == Max){
               wordsToBeReturned.put(word, Max);
           }
       }

        return wordsToBeReturned;


    }

    private static void wordCounter(final String input, final Map<Word, Integer> vaildator) {
        String[] split = input.split(" ");

        for(String string : split){
            Word word = new Word(string);
            if(vaildator.containsKey(word)){
                vaildator.put(word, vaildator.get(word) + 1);
            }else{
                vaildator.put(word, 1);
            }
        }
    }

    public static class Word {

        public Word(String string){
            this.newString = string;
        }

        String newString;

        @Override
        public int hashCode() {
            return newString.toLowerCase().hashCode();
        }

        @Override
        public boolean equals(final Object obj) {

            return newString.equalsIgnoreCase(obj.toString());
        }

        @Override
        public String toString() {
            return newString;
        }
    }




}
