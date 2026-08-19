import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashSet<String> reserved = new HashSet<>();
        HashSet<Integer> rows = new HashSet<>();

        // Store reserved seats
        for (int[] seat : reservedSeats) {
            reserved.add(seat[0] + "," + seat[1]);
            rows.add(seat[0]);
        }

        // All rows without reserved seats can take 2 families
        int count = (n - rows.size()) * 2;

        // Check only rows which have reserved seats
        for (int row : rows) {

            boolean left = true;
            boolean right = true;

            // Check seats 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(row + "," + seat)) {
                    left = false;
                    break;
                }
            }

            // Check seats 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(row + "," + seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                count += 2;
            }
            else if (left || right) {
                count += 1;
            }
            else {
                // Both left and right are blocked.
                // Check middle: 4,5,6,7

                boolean middle = true;

                for (int seat = 4; seat <= 7; seat++) {
                    if (reserved.contains(row + "," + seat)) {
                        middle = false;
                        break;
                    }
                }

                if (middle) {
                    count += 1;
                }
            }
        }

        return count;
    }
}