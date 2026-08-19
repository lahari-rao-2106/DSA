import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Sort by row
        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        // Initially, every row can have 2 families
        int answer = n * 2;

        int i = 0;

        while (i < reservedSeats.length) {

            int row = reservedSeats[i][0];

            // seats[seat] = true means reserved
            boolean[] seats = new boolean[11];

            // Store all reserved seats of this row
            while (i < reservedSeats.length &&
                   reservedSeats[i][0] == row) {

                seats[reservedSeats[i][1]] = true;
                i++;
            }

            boolean left = true;
            boolean right = true;
            boolean middle = true;

            // 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (seats[seat]) {
                    left = false;
                    break;
                }
            }

            // 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (seats[seat]) {
                    right = false;
                    break;
                }
            }

            // 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if (seats[seat]) {
                    middle = false;
                    break;
                }
            }

            // Decide families for this row
            if (left && right) {
                // 2 families
            }
            else if (left || right || middle) {
                // 1 family instead of 2
                answer--;
            }
            else {
                // 0 families instead of 2
                answer -= 2;
            }
        }

        return answer;
    }
}