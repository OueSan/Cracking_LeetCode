class Solution {
  public:
      string removeStars(string s) {
          vector<char> v;
          v.reserve(s.size());
          for (char c : s) {
              if(c == '*') {
                  v.pop_back();
                  continue;
              }
              v.push_back(c);
          }
          string res(v.begin(), v.end());
          return res;
      }
  };