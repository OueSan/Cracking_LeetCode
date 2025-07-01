class Solution {
  public int minDistance(String word1, String word2) {
      if (word1.length() < word2.length()) {
          return minDistance(word2, word1);
      }
      char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
      int[] dp = new int[w2.length];
      int last = 0;
      int diag = 0;
      for (int i = 0; i < dp.length; i++) {
          dp[i] = dp.length - i;
      }
      for (int i = w1.length - 1; i > -1; i--) {
          last = w1.length - i;
          diag = w1.length - 1 - i;
          for (int j = w2.length - 1; j > -1; j--) {
              int tmp = dp[j];
              if (w1[i] == w2[j]) {
                  last = dp[j] = diag;
              } else {
                  last = dp[j] = Math.min(diag, Math.min(dp[j], last)) + 1;
              }
              diag = tmp;
          }
      }
      return last;
  }
}