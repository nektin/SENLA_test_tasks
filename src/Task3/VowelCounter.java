package Task3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCounter {
    public static void counter() {
        System.out.print("Введите предложение:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        String[] words = text.split("[\\p{Punct}\\s]+");
        SortedSet<String> wordsList = new TreeSet<>();
        Collections.addAll(wordsList, words);

        Pattern vowelPattern = Pattern.compile("[аеёиоуыэюя]");
        Matcher matcher;
        SortedMap<String, Integer> countVowelInWords = new TreeMap<>();

        for (String word : wordsList) {
            int countVowel = 0;
            matcher = vowelPattern.matcher(word);
            while (matcher.find()) {
                countVowel++;
            }
            countVowelInWords.put(capitalizeFirstVowel(word), countVowel);
        }

        System.out.println("Слова отсоритированые по количеству гласных:");
        countVowelInWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    private static String capitalizeFirstVowel(String word) {
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isVowel(c, vowels)) {
                chars[i] = Character.toUpperCase(chars[i]);
                break;
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c, char[] vowels) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}
