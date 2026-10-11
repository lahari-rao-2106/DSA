
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }
        if (k >= total) {
            return 0;
        }
        int low = 0;
        int high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;
            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }
            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int level = low;
        long used = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                used += diff[i] - level;
                diff[i] = level;
            }
        }
        long remaining = k - used;
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == level && level > 0) {
                diff[i]--;
                remaining--;
            }
        }
        long sum = 0;
        for (int d : diff) {
            sum += (long) d * d;
        }
        return sum;
    }
}
