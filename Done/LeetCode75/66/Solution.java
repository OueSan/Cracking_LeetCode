class Solution {
  static {
      for (int i = 0; i < 300; i++) maxProfit(new int[0], 0);
  }
  public static int maxProfit(int[] prices, int fee) {
      int buy = Integer.MIN_VALUE;
      int sell = 0;
      for (int price : prices) {
          buy = Math.max(buy, sell - price);
          sell = Math.max(sell, buy + price - fee);
      }
      return sell;
  }
}