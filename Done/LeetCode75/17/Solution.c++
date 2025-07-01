class Solution {
  public:
      int longestSubarray(vector<int>& nums) {
          int left = 0;
          bool foundZero = false;
          int zeroIndex = 0;
          int result = 0;
  
          for (int right = 0; right < nums.size(); ++right)
          {
              if (nums[right] == 0 && foundZero == false)
              {
                  foundZero = true;
                  zeroIndex = right;
              }
              else if (nums[right] == 0 && foundZero == true)
              {
                  left = zeroIndex + 1;
                  zeroIndex = right;
              }
  
              result = std::max(result, right - left + (foundZero ? 0 : 1));
          }
  
          if (!foundZero)
          {
              --result;
          }
  
          return result;
      }
  };