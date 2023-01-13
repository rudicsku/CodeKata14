package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public static List<String> readLineByLine(String path) {

        if (path == null || path.isBlank()) {
            return new ArrayList<>();
        }

        List<String> fileListAsString = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileListAsString.add(line);
            }
        } catch (IOException exception) {
            System.out.println("File not found!");
            return new ArrayList<>();
        }
        return fileListAsString;
    }

    public static String makeString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
