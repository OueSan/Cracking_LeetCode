class TimeMap {
  public:
      unordered_map<string,vector<pair<int,string>>> m;
      TimeMap() {}
      
      void set(string key, string value, int timestamp) {
          m[key].push_back({timestamp,value});
      }
      
      string get(string key, int timestamp) {
          if(m.find(key)==m.end()) return "";
          if(m[key][0].first>timestamp) return "";
          int l=0,r=m[key].size()-1, middle = l+(r-l)/2;
          while(l<=r){
              middle = l+(r-l)/2;
              if(m[key][middle].first==timestamp) return m[key][middle].second;
              else if(timestamp>m[key][middle].first) l = middle+1;
              else r = middle-1;
          }
          if(l>r) return m[key][r].second;
          else return m[key][l].second;
      }
  };
  
  /**
   * Your TimeMap object will be instantiated and called as such:
   * TimeMap* obj = new TimeMap();
   * obj->set(key,value,timestamp);
   * string param_2 = obj->get(key,timestamp);
   */