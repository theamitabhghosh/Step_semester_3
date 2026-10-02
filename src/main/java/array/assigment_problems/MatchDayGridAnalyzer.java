package array.assigment_problems;

import java.util.Scanner;

public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] grid = new int[rows][];

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of columns for row " + (i + 1) + ": ");
            int columns = sc.nextInt();

            grid[i] = new int[columns];

            System.out.println("Enter values:");

            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Row averages:");

        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + ": " + rowAverage(grid[i]));
        }
    }
}