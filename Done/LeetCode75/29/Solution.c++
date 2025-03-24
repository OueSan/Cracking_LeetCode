class Solution {
  public:
      string predictPartyVictory(string senate) {
          
          int n=senate.size();
  
          queue<int>r,d;
  
          for(int i=0;i<n;i++)
          {
              if(senate[i]=='R')
              r.push(i);
              if(senate[i]=='D')
              d.push(i);
          }
  
          while(!r.empty() && !d.empty())
          {
              if(r.front()<d.front())
              {
                  n=n+1;
                  r.push(n);
              }
              else
              {
                  n=n+1;
                  d.push(n);
              }
              d.pop();
              r.pop();
          }
          if(r.empty())
          {
              return "Dire";
          }
          else
          {
              return "Radiant";
          }
      }
  };