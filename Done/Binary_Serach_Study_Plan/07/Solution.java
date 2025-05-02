class TimeMap {
  HashMap<String,ArrayList<Pair>> map;
  public TimeMap() {
      map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
      ArrayList<Pair> values = map.getOrDefault(key,new ArrayList<>());
      values.add(new Pair(value,timestamp));
      map.put(key,values);
  }
  
  public String get(String key, int timestamp) {
      if(map.containsKey(key)){
           ArrayList<Pair> values = map.get(key);
           int low=0;
           int high=values.size()-1;

           while(low<=high){
              int mid=low+(high-low)/2;

              if(values.get(mid).timestamp > timestamp){
                  high=mid-1;
              }
              else{
                  low=mid+1;
              }
           }
           if(high==-1){
              return "";
           }
           return values.get(high).value;
      }

      return "";
  }
}

class Pair{
  int timestamp;
  String value;

  Pair(String value,int timestamp){
      this.timestamp=timestamp;
      this.value=value;
  }
}

/**
* Your TimeMap object will be instantiated and called as such:
* TimeMap obj = new TimeMap();
* obj.set(key,value,timestamp);
* String param_2 = obj.get(key,timestamp);
*/