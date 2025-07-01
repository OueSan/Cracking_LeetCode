class Solution {
  private:
      bool is_vowel(char c) {
          return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
      }
  public:
      int maxVowels(string s, int k) {
          int n = s.size();
          int r, res = 0, curr = 0;
          for (r = 0; r < k; ++r) {
              if (is_vowel(s[r])) curr++;
          }
          res = curr;
          for (r = k; r < n; ++r) {
              curr -= is_vowel(s[r - k]);
              curr += is_vowel(s[r]);
              res = max(res, curr);
          }
          return res;
      }
  };