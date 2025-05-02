class Solution {
  public int arrangeCoins(int n) {
      return (int)(-1 + (Math.sqrt(1 + 8 * (long)n )))/2; // cast "n" to "long" to avoid integer overflow
  }
}