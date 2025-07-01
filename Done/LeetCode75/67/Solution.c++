class Solution {
  public:
      int fun(string& s, string& t, int i, int j, vector<vector<int>>& dp) {
          if(i < 0) return j + 1;
          if(j < 0) return i + 1;
          if(dp[i][j] != -1) return dp[i][j];
          if(s[i] == t[j]) return dp[i][j] = fun(s, t, i - 1, j - 1, dp);
          int x = 1 + fun(s, t, i, j - 1, dp);
          int y = 1 + fun(s, t, i - 1, j, dp);
          int z = 1 + fun(s, t, i - 1, j - 1, dp);
          return dp[i][j] = min(x, min(y, z));
      }
      int minDistance(string word1, string word2) {
          int n = word1.size();
          int m = word2.size();
          vector<vector<int>> dp(n, vector<int> (m, -1));
          return fun(word1, word2, n - 1, m - 1, dp);
      }
  };