class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        int n = arr.size(), res = -1, count = 0;
        vector<int> len(n + 2);
        for (int step = 0; step < n; ++step) {
            int i = arr[step];
            int left = len[i - 1], right = len[i + 1];
            int total = left + right + 1;
            len[i - left] = len[i + right] = total;
            len[i] = total;
            if (left == m) --count;
            if (right == m) --count;
            if (total == m) ++count;
            if (count) res = step + 1;
        }
        return res;
    }
};