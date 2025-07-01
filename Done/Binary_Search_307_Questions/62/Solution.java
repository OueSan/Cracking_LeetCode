class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Arrays.stream(piles).max().getAsInt();
        int ans = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Ceiling division
            }

            if (hours <= h) {
                ans = mid;
                max = mid - 1; // Try smaller speed
            } else {
                min = mid + 1; // Need faster speed
            }
        }

        return ans;
    }
}