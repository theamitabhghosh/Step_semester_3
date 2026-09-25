package OOP.class_problems;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.nextLine();

            String[] moves = {"Rock", "Paper", "Scissors"};
            String computer = moves[random.nextInt(3)];

            System.out.println("Computer: " + computer);

            if (player.equalsIgnoreCase(computer)) {
                System.out.println("Draw");
                draws++;
            }
            else if ((player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                     (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                     (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
                System.out.println("Player Wins");
                wins++;
            }
            else {
                System.out.println("Computer Wins");
                losses++;
            }
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");

        sc.close();
    }
}