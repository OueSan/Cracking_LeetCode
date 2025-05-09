class Solution {
  public:
      int findDuplicate(vector<int>& nums) {
          int n=nums.size();
          vector<int> temp(n,0);
  
          for(int i=0; i<n; i++){
              temp[nums[i]]++;
          }
          for(int i=0; i<temp.size(); i++){
              if(temp[i]>1) return i;
          }
          return 0;
      }
  };