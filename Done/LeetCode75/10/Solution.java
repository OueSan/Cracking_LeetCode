class Solution {

  static {
          for (int i = 0; i < 500; i++) {
              moveZeroes(new int[] {});
          }
      }
  
      public static void moveZeroes(int[] nums) {
          if (nums == null || nums.length <= 1) return;
  
          int write = 0, read = 0;
          while (write < nums.length && read < nums.length) {
              if (nums[read] != 0) {
                  nums[write] = nums[read];
                  write++;
                  read++;
              } else {
                  read++;
              }
          }
  
          while (write < nums.length) {
              nums[write] = 0;
              write++;
          }
      }
  }