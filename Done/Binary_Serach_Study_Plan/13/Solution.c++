// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
  public:
      int firstBadVersion(int n) {
          int start = 1, end = n;
          
          while(start < end) {
              int mid = start + (end - start) / 2;
              int isBad = isBadVersion(mid);
              
              if(!isBad) {
                  start = mid + 1;
                  continue;
              }
              end = mid;
          }
          
          if (isBadVersion(start)) {
              return start;
          }
          return -1;
      }
  };