class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = 0;

        for (int i = n - 1; i >= 2; i--) 
        {
            int l = 0, h = i - 1;
            while (l < h) 
            {
                if (nums[l] + nums[h] > nums[i]) 
                {
                    ans += (h - l);
                    h--;
                } else 
                {
                    l++;
                }
            }
        }
        return ans;
    }
};