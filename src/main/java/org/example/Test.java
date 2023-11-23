package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        String currentDirectory = System.getProperty("user.dir");

        File file1 = new File(currentDirectory, "src/main/resources/file1.txt");
        Task1 phoneValidator = new Task1();
        phoneValidator.validatePhoneNumbers(file1);
        System.out.println();

        File file2 = new File(currentDirectory, "src/main/resources/file2.txt");
        Task2 convertor = new Task2();
        convertor.convertFileToJson(file2);
        System.out.println();

        File file3 = new File(currentDirectory, "src/main/resources/words.txt");
        Task3 wordFrequencyCounter = new Task3();
        wordFrequencyCounter.countWordFrequency(String.valueOf(file3));
    }
}
