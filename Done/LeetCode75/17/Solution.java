class Solution {
  public int longestSubarray(int[] nums) {
      int n = nums.length;
      int k1 = 0, k2 = 0, i = 0;
      int mx = 0;
      while (i < n && nums[i] != 0) {
          k1 += 1;
          i += 1;
      }
      if (i == n) {
          return n-1;
      }
      i += 1;
      for (; i < n; i++) {
          if (nums[i] != 0) {
              k2 += 1;
          }
          else {
              mx = Math.max(mx, k1 + k2);
              k1 = k2;
              k2 = 0;
          }
      }
      mx = Math.max(mx, k1 + k2);
      return mx;
  }
}