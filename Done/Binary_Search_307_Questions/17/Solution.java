// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
  public:
      int firstBadVersion(int n) {
          int first = 1;
          int last = n;
  
          while (first < last) {
              int mid = first + (last - first) / 2;
  
              if (isBadVersion(mid)) {
                  last = mid; // Mid could be the first bad version, so narrow the
                              // range to the left half.
              } else {
                  first = mid + 1; // If mid is not bad, the first bad version
                                   // must be after mid.
              }
          }
  
          return first; // At the end, first will be the first bad version.
      }
  };