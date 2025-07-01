class Solution {
    int[] bl;
    int n;
    Random rand;

    public Solution(int n, int[] blacklist) {
        this.bl = blacklist;
        Arrays.sort(bl);
        this.n = n;
        this.rand = new Random();     
    }
    
    public int pick() {
        int k = rand.nextInt(n - bl.length);

        if (bl.length == 0) {
            return k;
        }
        int lo = 0;
        int hi = bl.length - 1;
        int lessThanEqualTo = 0;

        while (lo <= hi) {
            int pivot = lo + (hi - lo) / 2;
            int gap = bl[pivot] - pivot;

            if (gap <= k) {
                lo = pivot + 1;
                lessThanEqualTo = pivot;
            } else {
                hi = pivot - 1;
            }
        }
        // if it falls in the blacklist
        if (bl[lessThanEqualTo] - lo <= k) {
            return lessThanEqualTo + k + 1;
        }
        return k;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */