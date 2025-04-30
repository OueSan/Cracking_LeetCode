class Solution {
  public:
      vector<int> findClosestElements(vector<int>& arr, int k, int x) {
      priority_queue<pair<int, int>,vector<pair<int, int>>, greater<pair<int, int>>> pq;        
      for(int num: arr){
              pq.push({abs(x-num), num});
          }
          vector<int> ans;
          while(k--){
              ans.push_back(pq.top().second);
              pq.pop();
          }
          sort(ans.begin(), ans.end());
          return ans;
      }
  };