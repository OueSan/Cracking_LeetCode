class Solution {
  public int[] asteroidCollision(int[] asteroids) {
      int topElement = -1 ;
      for(int asteroid : asteroids){
          boolean stillAlive = true ;
          while(stillAlive && asteroid < 0 && topElement >=0 && asteroids[topElement] > 0){
              int currentSum = asteroid + asteroids[topElement];
              stillAlive = currentSum < 0 ;
              if(currentSum <= 0){
                  topElement--;
              }
          }
          if(stillAlive){
              asteroids[++topElement] = asteroid ;
          }
      }
      return Arrays.copyOf(asteroids, topElement+1);
  }
}