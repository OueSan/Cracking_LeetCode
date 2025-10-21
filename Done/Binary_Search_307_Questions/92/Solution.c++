class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        int n = arr.size();
        vector<int> left(n, INT_MAX);
        int sum = 0, start = 0, minLen = INT_MAX;
        for (int end = 0; end < n; ++end) {
            sum += arr[end];
            while (sum > target) sum -= arr[start++];
            if (sum == target) minLen = min(minLen, end - start + 1);
            left[end] = minLen;
        }
        sum = 0; minLen = INT_MAX;
        int res = INT_MAX, end = n - 1;
        for (int i = n - 1; i >= 0; --i) {
            sum += arr[i];
            while (sum > target) sum -= arr[end--];
            if (sum == target) {
                int len = end - i + 1;
                if (i && left[i - 1] < INT_MAX) res = min(res, left[i - 1] + len);
                minLen = min(minLen, len);
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};