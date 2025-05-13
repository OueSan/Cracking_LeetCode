public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == -1)
                high = mid - 1;
            if (guess(mid) == 1)
                low = mid + 1;
        }

        return -1;
    }
}