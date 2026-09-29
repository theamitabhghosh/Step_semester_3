package array.class_problems;

import java.util.Scanner;

public class ContainsDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] == nums[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                break;
            }
        }

        System.out.println("Contains Duplicate: " + duplicate);
    }
}