class Solution {
    public int preimageSizeFZF(int k) {
        int start = k * 4;
        while (true) {
            int H = trailingZeroes(start);
            if (H == k) return 5;
            if (H > k) break;
            start++;
        }
        return 0;
    }

    private int trailingZeroes(int n) {
        int sum = 0;
        for (int i = 1; i <= 13; i++) {
            sum += n / (int) Math.pow(5, i);
        }
        return sum;
    }
}