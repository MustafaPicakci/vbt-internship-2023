package org.vbt;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TextOperation {

    public String reverseWords(String words) {
        return StringUtils.reverse(words);
    }

    public Map<String, Integer> wordFrequency(String sentence) {

        Map<String, Integer> countMap = new HashMap<>();

        String[] words = sentence.toLowerCase().split(" ");

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        return countMap;
    }
}
