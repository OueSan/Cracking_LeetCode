class Solution {
  public:
      bool uniqueOccurrences(vector<int>& arr) {
          int n = arr.size();
          unordered_map<int,int> mp;
          int freq[1001] = {0};
  
          // Count their frequencies
          for(int i = 0; i<n; i++){
              mp[arr[i]]++;
          }
  
          // Check if their frequencies are unique
          for(auto &i : mp){
              freq[i.second]++;
              if(freq[i.second] > 1) return 0;
          }
          return 1;
      }
  };