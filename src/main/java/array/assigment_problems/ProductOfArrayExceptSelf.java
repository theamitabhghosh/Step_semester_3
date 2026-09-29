package array.assigment_problems;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] result = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int product = 1;

        for (int i = 0; i < n; i++) {
            result[i] = product;
            product = product * nums[i];
        }

        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        System.out.println("Result:");

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}