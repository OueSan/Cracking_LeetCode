class StockSpanner {
  public:
      stack<pair<int,int>>st;
      StockSpanner() {}
      
      int next(int price) {
          int span=1;
          while(!st.empty() && price>=st.top().first){
              span+=st.top().second;
              st.pop();
          }
          st.push({price,span});
          return span;
      }
  };