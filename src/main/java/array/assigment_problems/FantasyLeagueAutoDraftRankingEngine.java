package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private double points;
    private int matches;

    Player(String name, double points, int matches) {
        this.name = name;
        this.points = points;
        this.matches = matches;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public int getMatches() {
        return matches;
    }

    public static boolean isDraftable(double points, int matches) {
        return points >= 500 && matches >= 10;
    }

    public static boolean isDraftable(double points, int matches, boolean captainEligible) {
        return points >= 400 && matches >= 8 && captainEligible;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.points, this.points);
    }

    @Override
    public String toString() {
        return name + " - Points: " + points + ", Matches: " + matches;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter points: ");
            double points = sc.nextDouble();

            System.out.print("Enter matches: ");
            int matches = sc.nextInt();

            sc.nextLine();

            players[i] = new Player(name, points, matches);
        }

        Player[] shortlisted = new Player[n];
        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(
                    player.getPoints(),
                    player.getMatches())) {

                shortlisted[count] = player;
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        System.out.println("\nDraftable Players:");

        for (Player player : finalList) {
            System.out.println(player);
        }
    }
}