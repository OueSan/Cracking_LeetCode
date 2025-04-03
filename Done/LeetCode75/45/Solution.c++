class Solution {
  public:
      void dfs(vector<vector<int>>& isConnected, int y, vector<bool>& seen) {
          seen[y] = true;
          for (int i = 0; i < isConnected.size(); ++i) {
              if (!seen[i] && isConnected[y][i] == 1) {
                  dfs(isConnected, i, seen);
              }
          }
      }
      int findCircleNum(vector<vector<int>>& isConnected) {
          vector<bool> seen(isConnected.size());
          int provinces = 0;
          for (int y = 0; y < isConnected.size(); ++y) {
              if (!seen[y]) {
                  ++provinces;
                  dfs(isConnected, y, seen);
              }
          }
          return provinces;
      }
  };