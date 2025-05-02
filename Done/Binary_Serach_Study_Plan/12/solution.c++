/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *               1 if num is lower than the picked number
 *               0 if num is equal to the picked number
 * int guess(int num);
 */

 class Solution {
  public:
      int guessNumber(int n) {
          int st = 1, end = n, mid;
  
          while (st <= end) {
              mid = st + (end - st) / 2;
  
              int res = guess(mid); // Call the guess API
  
              if (res == -1) {
                  end = mid - 1;
              } else if (res == 1) {
                  st = mid + 1;
              } else {
                  return mid;
              }
          }
  
          return -1;
      }
  };