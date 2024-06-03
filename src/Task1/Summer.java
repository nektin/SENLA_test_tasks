package Task1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Summer {
    public static void sumNumbersFromText() {
        List<Integer> numbersList = new ArrayList<>();
        System.out.print("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern numbersPattern = Pattern.compile("[0-9]+");
        Matcher numbersMather = numbersPattern.matcher(text);
        while (numbersMather.find()) {
            numbersList.add(Integer.valueOf(numbersMather.group()));
        }

        System.out.print("Сумма чисел в тексте:");
        System.out.print(numbersList.stream()
                .mapToInt(a -> a)
                .sum());
    }
}
