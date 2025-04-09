class Solution {

  private int check(int[] piles, int h, int mid) {
      int ans = 0;
      for (int pile : piles) {
          ans += pile / mid;
          if (pile % mid != 0) {
              ans++;
          }
      }
      return ans <= h ? 1 : 0;
  }

  public int minEatingSpeed(int[] piles, int h) {
      int n = piles.length;
      int low = 1;
      int high = Arrays.stream(piles).max().getAsInt();

      while (low < high) {
          int mid = (low + high) >> 1;
          if (check(piles, h, mid) == 1) {
              high = mid;
          } else {
              low = mid + 1;
          }
      }
      return low;
  }
}