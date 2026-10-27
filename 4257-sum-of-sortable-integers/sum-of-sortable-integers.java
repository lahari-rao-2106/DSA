
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            boolean valid = true;
            int prevMax = 0;
            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;
                int min = nums[start];
                int max = nums[start];
                int drops = 0;
                for (int i = start; i <= end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                    int next = (i == end) ? start : i + 1;
                    if (nums[i] > nums[next]) drops++;
                }
                if (drops > 1) {
                    valid = false;
                    break;
                }
                if (start > 0 && prevMax > min) {
                    valid = false;
                    break;
                }
                prevMax = max;
            }
            if (valid) ans += k;
        }
        return ans;
    }
}
