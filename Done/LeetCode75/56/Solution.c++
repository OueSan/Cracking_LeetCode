class Solution {
  public:
  bool canEatAllBananas(vector<int>& piles, int speed, int h) {
      long hours = 0;
      for (long pile : piles) {
          hours += (pile + speed - 1) / speed;  // Equivalent to ceil(pile / speed)
      }
      return hours <= h;
  }
  int helper(vector<int>&nums,int low,int high,int h){
      if(low>high) return low;
      int mid=low+(high-low)/2;
      int flag=canEatAllBananas(nums,mid,h);
      if(!flag) return helper(nums,mid+1,high,h);
      else return helper(nums,low,mid-1,h);
  
  }
      int minEatingSpeed(vector<int>& piles, int h) {
           int left = 1, right = *max_element(piles.begin(), piles.end());
   return  helper(piles,left,right,h);
      
     
     
      }
  };