class Solution {
    public int stoneGameV(int[] a) {
        int n = a.length;
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++)
            p[i + 1] = p[i] + a[i];

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;

                for (int k = l; k < r; k++) {
                    int left = p[k + 1] - p[l];
                    int right = p[r + 1] - p[k + 1];

                    if (left <= right)
                        dp[l][r] = Math.max(dp[l][r], left + dp[l][k]);

                    if (right <= left)
                        dp[l][r] = Math.max(dp[l][r], right + dp[k + 1][r]);
                }
            }
        }

        return dp[0][n - 1];
    }
}