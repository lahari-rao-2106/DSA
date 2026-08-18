class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // CASE 1: k == 1
        if (k == 1) {

            int answer = -1;

            for (int i = 0; i < n; i++) {

                int count = 0;

                // Count how many times nums[i] occurs
                for (int j = 0; j < n; j++) {

                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                // Occurs exactly once
                if (count == 1) {
                    answer = Math.max(answer, nums[i]);
                }
            }

            return answer;
        }

        // CASE 2: k == n
        if (k == n) {

            int answer = nums[0];

            for (int i = 1; i < n; i++) {

                if (nums[i] > answer) {
                    answer = nums[i];
                }
            }

            return answer;
        }

        // CASE 3: 1 < k < n

        int first = nums[0];
        int last = nums[n - 1];

        int firstCount = 0;
        int lastCount = 0;

        // Count first and last elements
        for (int i = 0; i < n; i++) {

            if (nums[i] == first) {
                firstCount++;
            }

            if (nums[i] == last) {
                lastCount++;
            }
        }

        // Both occur exactly once
        if (firstCount == 1 && lastCount == 1) {
            return Math.max(first, last);
        }

        // Only first occurs exactly once
        if (firstCount == 1) {
            return first;
        }

        // Only last occurs exactly once
        if (lastCount == 1) {
            return last;
        }

        // Neither occurs exactly once
        return -1;
    }
}