package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public String getName() {
        return name;
    }

    public static boolean isShortlisted(double cgpa, int codingScore) {
        return cgpa >= 7.5 && codingScore >= 60;
    }

    public static boolean isShortlisted(double cgpa, int codingScore, boolean interviewEligible) {
        return cgpa >= 7.0 && codingScore >= 55 && interviewEligible;
    }

    @Override
    public int compareTo(Candidate other) {

        if (this.cgpa != other.cgpa) {
            return Double.compare(other.cgpa, this.cgpa);
        }

        return Integer.compare(other.codingScore, this.codingScore);
    }

    @Override
    public String toString() {
        return name + " - CGPA: " + cgpa + ", Coding Score: " + codingScore;
    }
}

public class PlacementDriveRankingEngine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        Candidate[] shortlisted = new Candidate[n];
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isShortlisted(
                    candidate.getCgpa(),
                    candidate.getCodingScore())) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        System.out.println("\nShortlisted Candidates:");

        for (Candidate candidate : finalList) {
            System.out.println(candidate);
        }
    }
}