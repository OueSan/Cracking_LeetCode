class Solution {
    static int[][] dp;

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(k, n);
    }

    public int helper(int k, int n) {
        if (n == 0 || n == 1) return n;
        if (k == 1) return n;

        if (dp[k][n] != -1) return dp[k][n];

        int low = 1, high = n, min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            int breakEgg = helper(k - 1, mid - 1);
            int noBreak = helper(k, n - mid);
            int worst = 1 + Math.max(breakEgg, noBreak);

            if (breakEgg > noBreak) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            min = Math.min(min, worst);
        }

        return dp[k][n] = min;
    }
}