class Solution {
    vector<int> DP;

public:
    int solve(int i, vector<int>& nums) {
        int n = nums.size();
        if (i >= n) {
            return 0;
        }
        if (DP[i] != INT_MIN) {
            return DP[i];
        }
        int ans = nums[i] - solve(i + 1, nums);
        if (i + 1 < n) {
            ans = max(ans, nums[i] + nums[i + 1] - solve(i + 2, nums));
        }
        if (i + 2 < n) {
            ans = max(ans,
                      nums[i] + nums[i + 1] + nums[i + 2] - solve(i + 3, nums));
        }
        return DP[i] = ans;
    }

    string stoneGameIII(vector<int>& stoneValue) {
        int n = stoneValue.size();
        DP.assign(n + 1, INT_MIN);
        int ans = solve(0, stoneValue);
        if (ans < 0) {
            return "Bob";
        } else if (ans == 0) {
            return "Tie";
        } else {
            return "Alice";
        }
    }
};