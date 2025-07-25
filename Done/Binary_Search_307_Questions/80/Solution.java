import java.util.*;

class Solution {
    public int find(int i, int[][] job, int[] startTime, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int index = Arrays.binarySearch(startTime, job[i][1]);
        if (index < 0) index = -index - 1;

        int pick = job[i][2] + find(index, job, startTime, n, dp);
        int notpick = find(i + 1, job, startTime, n, dp);
        return dp[i] = Math.max(pick, notpick);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] job = new int[n][3];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }

        Arrays.sort(job, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(startTime);

        return find(0, job, startTime, n, dp);
    }
}

