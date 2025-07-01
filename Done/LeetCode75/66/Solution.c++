class Solution {
  public:
      int maxProfit(vector<int>& prices, int fee) {
          int hold = -prices[0];  // Max profit if holding a stock
          int cash = 0;           // Max profit if not holding a stock
          
          for (int i = 1; i < prices.size(); i++) {
              hold = max(hold, cash - prices[i]);              // Buy or hold
              cash = max(cash, hold + prices[i] - fee);        // Sell or hold
          }
          
          return cash;  // Max profit is when not holding a stock
      }
  };