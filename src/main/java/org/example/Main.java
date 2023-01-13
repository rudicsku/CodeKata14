package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = ReadFromFile.readLineByLine("/Users/HU900849/Desktop/CodeKata/CodeKata-14/src/main/resources/text.txt");
        String string = ReadFromFile.makeString(list);

        System.out.println(Triagram.triagram("az", "a", string));
    }
}