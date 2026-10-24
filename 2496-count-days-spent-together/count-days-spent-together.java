
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        int[] date = new int[4];
        String[] s = {arriveAlice, leaveAlice, arriveBob, leaveBob};

        for (int i = 0; i < 4; i++) {
            int month = Integer.parseInt(s[i].substring(0, 2));
            int day = Integer.parseInt(s[i].substring(3, 5));

            int total = day;

            for (int j = 0; j < month - 1; j++) {
                total += days[j];
            }

            date[i] = total;
        }

        int start = date[0];
        if (date[2] > start) {
            start = date[2];
        }

        int end = date[1];
        if (date[3] < end) {
            end = date[3];
        }

        int count = 0;

        for (int i = start; i <= end; i++) {
            count++;
        }

        return count;
    }
}
