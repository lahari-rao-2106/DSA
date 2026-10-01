import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);
        int answer = n * 2;
        int i = 0;
        while (i < reservedSeats.length) {
            int row = reservedSeats[i][0];
            boolean[] seats = new boolean[11];
            while (i < reservedSeats.length && reservedSeats[i][0] == row) {
                seats[reservedSeats[i][1]] = true;
                i++;
            }
            boolean left = true;
            boolean right = true;
            boolean middle = true;
            for (int seat = 2; seat <= 5; seat++) {
                if (seats[seat]) {
                    left = false;
                    break;
                }
            }
            for (int seat = 6; seat <= 9; seat++) {
                if (seats[seat]) {
                    right = false;
                    break;
                }
            }
            for (int seat = 4; seat <= 7; seat++) {
                if (seats[seat]) {
                    middle = false;
                    break;
                }
            }
            if (left && right) {
            } else if (left || right || middle) {
                answer--;
            } else {
                answer -= 2;
            }
        }
        return answer;
    }
}
