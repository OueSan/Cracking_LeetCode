import java.util.*;

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int ans = -1;
        
        // Arrays to keep track of lengths of segments ending at each position and counts of these lengths
        int[] lenAtIndex = new int[n + 2];
        int[] countLen = new int[n + 2];

        for (int i = 0; i < n; ++i) {
            int leftLen = lenAtIndex[arr[i] - 1]; // Length of segment ending just before arr[i]
            int rightLen = lenAtIndex[arr[i] + 1]; // Length of segment starting just after arr[i]

            int newLen = leftLen + rightLen + 1; // New length of the segment that includes arr[i]

            // Update the lengths at arr[i], arr[i] - leftLen, and arr[i] + rightLen
            lenAtIndex[arr[i]] = newLen;
            lenAtIndex[arr[i] - leftLen] = newLen;
            lenAtIndex[arr[i] + rightLen] = newLen;

            // Update countLen array to reflect the change in segment lengths
            countLen[leftLen]--;
            countLen[rightLen]--;
            countLen[newLen]++;

            // Check if there is any segment of length m after this step
            if (countLen[m] > 0) {
                ans = i + 1; // Update ans to the current step (1-based index)
            }
        }

        return ans;
    }
}