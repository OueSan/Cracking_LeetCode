class Solution {
  public int findKthLargest(int[] nums, int k) {
     int n = nums.length;
     if(n == 0) return -1;
     if(n<k) return -1;
     int [] count = new int[20001];
     for(int i:nums){
         count[i+10000]++;
     }
     for(int i = 20000;i>0;i--){
      if(count[i]>0) k -= count[i];
      if(k<=0) return i - 10000;
     }
     return -1;
  }
}