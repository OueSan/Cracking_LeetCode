class Solution {
  public int minEatingSpeed(int[] piles, int h) {
      int n = piles.length;
      long total = 0;
      for(int p:piles){
          total += p;
      }
      int low = (int)((total-1)/h) + 1;
      int high = (int)((total-n)/(h-n+1)) + 1;
      while(low<high){
          int mid = low+(high-low)/2;
          int time = 0;
          for(int p: piles){
              time += (p-1)/mid +1;
          }
          if(time>h)  low = mid+1;
          else high = mid; 
      }
      return low;
  }
}