class Solution {
    public int minimumBoxes(int n) {
        int x = (int) Math.pow(6 * n, 1.0 / 3.0);
        if (x * (x + 1) * (x + 2) > 6 * n) {
            x -= 1;
        }
        n -= x * (x + 1) * (x + 2) / 6;
        return x * (x + 1) / 2 + (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2.0);
    }
}