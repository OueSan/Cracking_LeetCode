class Solution {
  public:
      double findMaxAverage(vector<int>& nums, int k) {
          double sum=0;
          double ans=0;
          for(int i=0;i<k;i++){
              ans+=nums[i];}
              sum=ans;
          for(int i=k;i<nums.size();i++){
              sum+=nums[i]-nums[i-k];
              ans=max(ans,sum);
          }
          return ans/k;
      }
  };