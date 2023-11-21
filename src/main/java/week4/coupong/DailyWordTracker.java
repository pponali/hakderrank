package week4.coupong;

import java.util.*;

/**
 * @Author prakashponali
 * @Date 20/11/23
 * @Description
 */
public class DailyWordTracker {
    private HashMap<Date, HashMap<String, Integer>> dailyWordCounts = new HashMap<>();
    private HashMap<Date, PriorityQueue<WordFrequency>> topWords = new HashMap<>();


    //unit test cases for below methods addWord method
    public void addWord(Date date, String word) {
        dailyWordCounts.putIfAbsent(date, new HashMap<>());
        HashMap<String, Integer> wordCounts = dailyWordCounts.get(date);

        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);

        updateTopWords(date, word, wordCounts.get(word));
    }

    private void updateTopWords(Date date, String word, int frequency) {
        PriorityQueue<WordFrequency> queue = topWords.getOrDefault(date, new PriorityQueue<>());

        if (queue.size() < 10 || queue.peek().getFrequency() < frequency) {
            if (queue.size() == 10) {
                queue.poll();
            }
            queue.add(new WordFrequency(word, frequency));
        }

        topWords.put(date, queue);
    }

    public List<WordFrequency> getTopWords(Date date) {
        return new ArrayList<>(topWords.getOrDefault(date, new PriorityQueue<>()));
    }

    public class WordFrequency implements Comparable<WordFrequency> {
        private String word;
        private int frequency;

        public WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFrequency other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }
}
