package test;

import java.util.Scanner;

public class BrickSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int sets = 0;

            // While we can form at least one set, keep trying
            while (a > 0 && b > 0 && c > 0) {
                // Try to form as many sets as possible with the current bricks
                int possibleSets = Math.min(a, Math.min(b, c));
                sets += possibleSets;

                // Decrease the counts based on the sets formed
                a -= possibleSets;
                b -= possibleSets;
                c -= possibleSets;

                // Try to convert remaining red bricks to blue bricks
                int newBlueBricks = a / x;
                b += newBlueBricks;
                a %= x;  // Remaining red bricks after conversion

                // Try to convert remaining blue bricks to green bricks
                int newGreenBricks = b / y;
                c += newGreenBricks;
                b %= y;  // Remaining blue bricks after conversion
            }

            System.out.println(sets);
        }

        scanner.close();
    }
}