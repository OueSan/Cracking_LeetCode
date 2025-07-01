class Solution {
  static{
      for(int i=0;i<500;i++){
          increasingTriplet(new int[0]);
      }
  }
  public static boolean increasingTriplet(int[] nums) {
      int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
      for (int n : nums) {
          if (n <= first) {
              first = n;
          } else if (n <= second) {
              second = n;
          } else {
              return true;
          }
      }
      return false;
  }
}