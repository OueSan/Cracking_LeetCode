class Solution {
  public:
      vector<vector<int>> findDifference(vector<int>& a, vector<int>& b) {
          vector<vector<int>> ans(2);
  
          bitset<2001> ba;
          bitset<2001> bb;
          for(int x:a) ba[x+1000] = 1;
          for(int x:b) bb[x+1000] = 1;
      
          for(int i=2000;i>=0;i--)
          {
              if(ba[i] and !bb[i])
                  ans[0].push_back(i-1000);
              if(!ba[i] and bb[i])
                  ans[1].push_back(i-1000);
          }
  
          return ans;
      }
  };