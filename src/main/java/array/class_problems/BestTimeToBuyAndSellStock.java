package array.class_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {

            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        System.out.println("Maximum Profit: " + maxProfit);
    }
}