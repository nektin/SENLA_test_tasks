package Task2;

import java.util.ArrayList;
import java.util.Scanner;

public class FactorizationPrimeNumbers {
    public static void factorization() {
        System.out.print("Введите число:");
        Scanner scanner = new Scanner(System.in);
        double inputNumber = scanner.nextDouble();
        ArrayList<Integer> primeFactorsList = new ArrayList<>();

        if (inputNumber % 1 != 0) {
            System.out.println("Число не является целым");
        } else {
            int number = (int) inputNumber;
            for (int i = 2; i <= number; i++) {
                if (i * i > number) {
                    i = number;
                }
                while (number % i == 0) {
                    primeFactorsList.add(i);
                    number /= i;
                }
            }

            System.out.print("Простые множетели числа " + (int) inputNumber + ":");
            System.out.print(primeFactorsList);
        }
    }
}
