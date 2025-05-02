class Solution {
  public:
      vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
          sort(potions.begin(), potions.end());
          int m = potions.size();
          vector<int> res;
  
          for (int spell : spells) {
              int low = 0, high = m - 1;
              while (low <= high) {
                  int mid = low + (high - low) / 2;
                  long long product = (long long) spell * potions[mid];
                  if (product >= success) {
                      high = mid - 1;
                  } else {
                      low = mid + 1;
                  }
              }
              res.push_back(m - (high + 1));
          }
  
          return res;
      }
  };