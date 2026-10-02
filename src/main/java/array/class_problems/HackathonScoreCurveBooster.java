package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class HackathonScoreCurveBooster {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 50) {
                scores[i] += 10;
            }
        }

        System.out.println("Updated scores: " + Arrays.toString(scores));
    }
}