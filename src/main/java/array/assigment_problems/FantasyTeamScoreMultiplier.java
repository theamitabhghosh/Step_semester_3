package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class FantasyTeamScoreMultiplier {

    static void applyCaptainMultiplier(double[] points, int captainIndex, int viceCaptainIndex) {

        points[captainIndex] = points[captainIndex] * 2;
        points[viceCaptainIndex] = points[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        double[] points = new double[n];

        System.out.println("Enter player points:");
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextDouble();
        }

        System.out.print("Enter captain index: ");
        int captainIndex = sc.nextInt();

        System.out.print("Enter vice-captain index: ");
        int viceCaptainIndex = sc.nextInt();

        applyCaptainMultiplier(points, captainIndex, viceCaptainIndex);

        System.out.println("Updated points: " + Arrays.toString(points));
    }
}