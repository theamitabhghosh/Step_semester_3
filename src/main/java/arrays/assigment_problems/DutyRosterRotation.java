package arrays.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;

        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        System.out.println(Arrays.toString(rotated));
    }
}