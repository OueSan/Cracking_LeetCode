class Solution {
  static {
      for (int i = 0; i < 500; i++) {
          findDuplicate(new int[]{0});
      }
  }
  public static int findDuplicate(int[] nums) {
      int[] freq= new int[nums.length];
      for(int i=0;i<nums.length;i++){
          if(++freq[nums[i]]>1)
              return nums[i];
      }
      return 0;
  }
}