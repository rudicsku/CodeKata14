package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Triagram {
    public static String triagram(String firstWord, String secWord, String text) {

        //Create a new map
        Random rand = new Random();
        Map<String, List<String>> wordMap = new HashMap<>();
        String first = firstWord.toLowerCase();
        String sec = secWord.toLowerCase();

        //Make a list of strings from the text
        List<String> wordsList = makeListFromString(text);

        //Creating new text
        List<String> result = new ArrayList<>(List.of(first, sec));

        while (true) {
            String lastWord = result.get(result.size() - 1);
            String lastBeforeLastWord = result.get(result.size() - 2);
            String temp = lastBeforeLastWord + " " + lastWord;

            List<String> values = checkFor3rdWord(lastBeforeLastWord, lastWord, wordsList);
            if (values.isEmpty()) {
                break;
            }

            if (wordMap.containsKey(temp)) {
                List<String> tempList = new ArrayList<>(wordMap.get(temp));
                tempList.addAll(values);
                wordMap.replace(temp, tempList);
            } else {
                wordMap.put(temp, values);
            }

            List<String> tempValues = wordMap.get(temp);
            String nextWord = tempValues.get(rand.nextInt(tempValues.size()));
            result.add(nextWord);
        }

        //Stringbuilder to build the result
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : result) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString().length());
        return stringBuilder.toString();
    }

    private static List<String> makeListFromString(String text) {
        String[] splittedText = text.split(" ");
        return Arrays.stream(splittedText)
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static List<String> checkFor3rdWord(String firstWord, String secWord, List<String> wordsList) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < wordsList.size() - 2; i++) {
            if (wordsList.get(i).equals(firstWord) && wordsList.get(i + 1).equals(secWord)) {
                result.add(wordsList.get(i + 2));
            }
        }
        return result;
    }
}
