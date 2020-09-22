/*
 * Author: Kaden Payne
 * Date: 9/18/2020
 * 
 * Counting the occurrence of words in a sentence
 */
import java.util.*;
/**
 *
 * @author kjpay
 */
public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        String text = "Good morning. Have a good class. Have a good visit. Have fun!";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        String[] words = text.split("[ \\n\\t\\r.,;:!?(){]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            
            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        
        ArrayList<WordOccurrence> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry: entrySet) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        for (WordOccurrence item : list) {
            System.out.println(item);
        }
        
        //map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}

class WordOccurrence implements Comparable<WordOccurrence> {
        String word;
        int count;
        
        public WordOccurrence(String word, int value) {
            this.word = word;
            this.count = value;
        }
        @Override
        public int compareTo(WordOccurrence o) {
            if (this.count > o.count) {
                return 1;
            }
            else if (this.count == o.count) {
                return 0;
            }
            else {
                return -1;
            }
        }
        @Override
        public String toString() {
            return word + " " + count;
        }
    }
