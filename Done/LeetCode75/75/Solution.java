class Solution {
  public int[] dailyTemperatures(int[] temp) {
      int n = temp.length;
      int hottest = 0;
      int[] res = new int[n];
      for(int i = n-1;i>=0;i--){
          int curTemp = temp[i];
          if(curTemp >= hottest){
              hottest = curTemp;
              continue;
          }
          int days = 1;
          while(temp[i + days] <= curTemp){
              days += res[i + days];
          }
          res[i] = days;
      }
      return res;
  }
}