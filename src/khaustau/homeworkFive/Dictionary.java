package khaustau.homeworkFive;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public static void main(String[] args) {
        Map<String, Integer> dict = new HashMap<>();
        String text = "one two three one two one";

        String[] words = text.split("\\W+");

        for (String word : words) {
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            } else {
                dict.put(word,1);
            }
        }

        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " time"
                    + (entry.getValue() > 1 ? "s" : ""));
        }

    }
}
