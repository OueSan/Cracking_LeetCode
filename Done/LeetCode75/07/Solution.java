class Solution {
  static {
      for (int i = 0; i < 500; i++) {
          productExceptSelf(new int[] { 0, 0 });
      }
  }
      public static int[] productExceptSelf(int[] nums) {
      int[] output = new int[nums.length];
      output[nums.length - 1] = 1;
      int mult = nums[0];
      for (int index = nums.length - 2; index >= 0; index--) {
          output[index] = nums[index + 1] * output[index + 1];
      }
      for (int index = 1; index < nums.length; index++) {
          output[index] = mult * output[index];
          mult = mult * nums[index];
      }
      return output;
  }
}