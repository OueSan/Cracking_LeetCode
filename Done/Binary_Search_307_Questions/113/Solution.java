class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        return dfs(events, 0, -1, k);
    }

    int dfs(int[][] ev, int i, int lastEnd, int k) {
        if (i == ev.length || k == 0) return 0;
        int take = 0;
        if (ev[i][0] > lastEnd) take = ev[i][2] + dfs(ev, i + 1, ev[i][1], k - 1);
        int skip = dfs(ev, i + 1, lastEnd, k);
        return Math.max(take, skip);
    }
}