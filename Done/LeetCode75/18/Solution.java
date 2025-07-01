class Solution {
  public int largestAltitude(int[] gain) {
      int maxAltitude = 0;
      int result = 0;
      for(int item : gain){
          result += item;
          if(result > maxAltitude){
              maxAltitude = result;
          }
      }

      return maxAltitude;
      
  }
}