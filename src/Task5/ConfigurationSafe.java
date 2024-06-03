package Task5;

import java.util.ArrayList;


public class ConfigurationSafe {
    public static void fillingByMaxValue(ArrayList<Item> itemsList, int maxSafeWeight) {
        int[] weights = new int[itemsList.size()];
        int[] prices = new int[itemsList.size()];
        for (int i = 0; i < itemsList.size(); i++) {
            weights[i] = itemsList.get(i).getWeight();
            prices[i] = itemsList.get(i).getCost();
        }
        int count = weights.length;

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxSafeWeight + 1];
        }

        for (int weightItem = 0; weightItem <= count; weightItem++) {
            for (int safeWeight = 0; safeWeight <= maxSafeWeight; safeWeight++) {
                if (weightItem == 0 || safeWeight == 0) {
                    A[weightItem][safeWeight] = 0;
                } else {
                    if (safeWeight >= weights[weightItem - 1]) {
                        A[weightItem][safeWeight] = Math.max(A[weightItem - 1][safeWeight],
                                A[weightItem - 1][safeWeight - weights[weightItem - 1]] + prices[weightItem - 1]);
                    } else {
                        A[weightItem][safeWeight] = A[weightItem - 1][safeWeight];
                    }
                }
            }
        }

        ArrayList<Item> result = new ArrayList<>();
        traceResult(A, weights, count, maxSafeWeight, result, itemsList);
        printResult(itemsList, result, maxSafeWeight);
    }

    private static void traceResult(int[][] arrayOptimalCost, int[] weight, int weightItem, int safeWeight,
                                    ArrayList<Item> result, ArrayList<Item> itemList) {
        if (arrayOptimalCost[weightItem][safeWeight] == 0) {
            return;
        }
        if (arrayOptimalCost[weightItem - 1][safeWeight] == arrayOptimalCost[weightItem][safeWeight]) {
            traceResult(arrayOptimalCost, weight, weightItem - 1, safeWeight, result, itemList);
        } else {
            traceResult(arrayOptimalCost, weight, weightItem - 1, safeWeight - weight[weightItem - 1],
                    result, itemList);
            result.add(itemList.get(weightItem - 1));
        }
    }

    private static void printResult(ArrayList<Item> itemsList, ArrayList<Item> result, int maxSafeWeight) {
        System.out.println("Список предметов:");
        for (Item item : itemsList) {
            Item.printInfo(item);
        }
        System.out.println();
        System.out.println("Вместимость сейфа = " + maxSafeWeight);
        System.out.println();
        System.out.println("Набор предметов по максимальной стоимости:");
        for (Item item : result) {
            Item.printInfo(item);
        }
    }
}
