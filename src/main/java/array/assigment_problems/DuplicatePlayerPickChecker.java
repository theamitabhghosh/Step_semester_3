package array.assigment_problems;

import java.util.Scanner;

public class DuplicatePlayerPickChecker {

    static String findDuplicatePlayer(String[] players) {

        for (int i = 0; i < players.length; i++) {

            for (int j = i + 1; j < players.length; j++) {

                if (players[i].equals(players[j])) {
                    return "Duplicate Player Found: " + players[i];
                }
            }
        }

        return "No Duplicate Player Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] players = new String[n];

        System.out.println("Enter player names:");

        for (int i = 0; i < n; i++) {
            players[i] = sc.nextLine();
        }

        System.out.println(findDuplicatePlayer(players));
    }
}