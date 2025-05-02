class Solution {
  public boolean isPerfectSquare(int num) {
      int x = num;
      while (x * x > num) {
          x = (x + num / x) / 2;
      }
      return x * x == num;
      
  }
}