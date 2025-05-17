class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int m = heaters.length;
        int r = Math.max(heaters[0] - houses[0], houses[n-1] - heaters[m-1]);
        int j = 0;

        for (int i = 1; i < m; i++) {
            if (heaters[i-1]+r >= heaters[i]-r) {
                continue;
            }
            while (j < n && houses[j] <= heaters[i-1]+r) j++;

            while (j < n && houses[j] > heaters[i-1]+r && houses[j] < heaters[i]-r) {
                r += Math.min(houses[j] - (heaters[i-1]+r), (heaters[i]-r) - houses[j]);
                j++;
            }
        }

        return r;
    }
}