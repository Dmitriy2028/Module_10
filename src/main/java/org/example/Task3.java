package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public void countWordFrequency(String filePath) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.trim();
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordFrequencyMap.entrySet().stream()
                .sorted((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        //return wordFrequencyMap;
    }

}
