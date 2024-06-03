package Task4;

import java.util.*;


public class TalonsCreator {
    public static void talonPrint() {
        Scanner scanner = new Scanner(System.in);

        String[] formPrintNumbers = {
                "***\n* *\n* *\n* *\n***",   // 0
                "  *\n  *\n  *\n  *\n  *",   // 1
                "***\n  *\n***\n*  \n***",   // 2
                "***\n  *\n***\n  *\n***",   // 3
                "* *\n* *\n***\n  *\n  *",   // 4
                "***\n*  \n***\n  *\n***",   // 5
                "***\n*  \n***\n* *\n***",   // 6
                "***\n  *\n  *\n  *\n  *",   // 7
                "***\n* *\n***\n* *\n***",   // 8
                "***\n* *\n***\n  *\n***"    // 9
        };
        String[] formPrintLargestNumbers = {
                "000\n0 0\n0 0\n0 0\n000",   // 0
                "  1\n  1\n  1\n  1\n  1",   // 1
                "222\n  2\n222\n2  \n222",   // 2
                "333\n  3\n333\n  3\n333",   // 3
                "4 4\n4 4\n444\n  4\n  4",   // 4
                "555\n5  \n555\n  5\n555",   // 5
                "666\n6  \n666\n6 6\n666",   // 6
                "777\n  7\n  7\n  7\n  7",   // 7
                "888\n8 8\n888\n8 8\n888",   // 8
                "999\n9 9\n999\n  9\n999"    // 9
        };

        System.out.print("Введите число: ");
        String number = scanner.nextLine();
        List<Integer> numbersList = new ArrayList<>();
        char[] separatedNumbers = number.toCharArray();
        for (char separatedNumber : separatedNumbers) {
            numbersList.add(Character.getNumericValue(separatedNumber));
        }
        int bigNumber = Collections.max(numbersList);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < number.length(); j++) {
                int oneNumber = Character.getNumericValue(number.charAt(j));
                String[] lines;
                if (oneNumber == bigNumber) {
                    lines = formPrintLargestNumbers[oneNumber].split("\n");
                } else {
                    lines = formPrintNumbers[oneNumber].split("\n");
                }
                System.out.print(lines[i] + " ");

            }
            System.out.println();
        }
    }
}
