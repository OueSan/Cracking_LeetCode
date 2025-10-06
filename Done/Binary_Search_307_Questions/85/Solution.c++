class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; ++i) prefix[i + 1] = prefix[i] + arr[i];
        int left = 0, right = arr[n - 1], best = 0, minDiff = INT_MAX;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = upper_bound(arr.begin(), arr.end(), mid) - arr.begin();
            int sum = prefix[idx] + (n - idx) * mid;
            int diff = abs(sum - target);
            if (diff < minDiff || (diff == minDiff && mid < best)) {
                best = mid;
                minDiff = diff;
            }
            if (sum < target) left = mid + 1;
            else right = mid - 1;
        }
        return best;
    }
};