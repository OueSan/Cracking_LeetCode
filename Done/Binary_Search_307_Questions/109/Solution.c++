class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        constexpr int MOD = 1e9 + 7;
        int res = 0, n = nums.size();
        partial_sum(nums.begin() , nums.end() , nums.begin());
        int total = nums[n - 1];
        for(int i = 0, j = 0, k = 0; i < n - 2; ++i){
            int left = nums[i];
            j = max(i + 1 , j);
            while(j < n - 1 && nums[j] < 2 * left) ++j;
            k = max(j , k);
            while(k < n - 1 && nums[k] - left <= total - nums[k]) ++k;
            res = (res + k - j) % MOD;
        }
        return res;
    }
};