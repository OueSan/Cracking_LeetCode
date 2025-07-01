class Solution {
  public:
      int findMinArrowShots(vector<vector<int>>& p) {
          int n=p.size();
          sort(p.begin(),p.end());
          int x=p[0][1];
          int ans=1;
          for(int i=1;i<n;i++){
              if(x>=p[i][0]){
                  x=min(x,p[i][1]);
              }
              else{
                  ans++;
                  x=p[i][1];
              }
          }
          return ans;
      }
  };