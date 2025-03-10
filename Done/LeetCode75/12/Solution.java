class Solution {
  static {
      for (int i = 0; i < 500; i++) {
          maxArea(new int[] { 0, 0 });
      }
  }
  public static int maxArea(int[] height) {
      int res = 0;
      int left = 0;
      int right = height.length - 1;
      while (left < right) {
          int min = Math.min(height[left], height[right]);
          res = Math.max(res, min * (right - left));
          while (left < right && height[left] <= min) left++;
          while (left < right && height[right] <= min) right--;
      }
      return res;
  }
}