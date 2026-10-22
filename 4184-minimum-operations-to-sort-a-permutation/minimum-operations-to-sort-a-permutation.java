
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int inc = 1, dec = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n)
                inc = 0;
            if (nums[i] != (nums[0] - i + n) % n)
                dec = 0;
        }

        int ans = Integer.MAX_VALUE;

        if (inc == 1) {
            int k = nums[0];
            ans = Math.min(ans, Math.min((n - k) % n, k + 2));
        }

        if (dec == 1) {
            int k = (n - 1 - nums[0] + n) % n;
            ans = Math.min(ans, 1 + Math.min(k, (n - k) % n));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
