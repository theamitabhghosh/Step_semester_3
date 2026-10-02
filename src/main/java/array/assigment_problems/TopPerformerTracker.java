package array.assigment_problems;

import java.util.Scanner;

public class TopPerformerTracker {

    static int[] findMinMax(int[] scores) {

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] > max) {
                max = scores[i];
            }

            if (scores[i] < min) {
                min = scores[i];
            }
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter player scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int[] result = findMinMax(scores);

        System.out.println("Maximum Score: " + result[0]);
        System.out.println("Minimum Score: " + result[1]);
    }
}