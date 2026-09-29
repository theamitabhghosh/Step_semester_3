package array.class_problems;

import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] b = new int[m];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {

            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < n) {
            result[k++] = a[i++];
        }

        while (j < m) {
            result[k++] = b[j++];
        }

        System.out.println("Merged Array:");

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}