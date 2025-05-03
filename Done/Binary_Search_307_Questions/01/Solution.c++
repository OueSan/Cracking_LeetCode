class Solution {
  public:
      double findMedianSortedArrays(vector<int>& arr1, vector<int>& arr2) {
          int n = arr1.size(), m = arr2.size();
          int mid1 = (n + m) / 2 - 1, mid2 = (n + m) / 2;
          int ans1 = 0, ans2 = 0;
          int idx1 = 0, idx2 = 0;
          int c = 0;
  
          while(c <= mid2 && idx1 < n && idx2 < m) {
              if(arr1[idx1] <= arr2[idx2]) {
                  if(c == mid1) ans1 = arr1[idx1];
                  if(c == mid2) ans2 = arr1[idx1];
                  idx1++;
              }
              else {
                  if(c == mid1) ans1 = arr2[idx2];
                  if(c == mid2) ans2 = arr2[idx2];
                  idx2++;
              }
              c++;
          }
          while(c <= mid2 && idx1 < n) {
              if(c == mid1) ans1 = arr1[idx1];
              if(c == mid2) ans2 = arr1[idx1];
              idx1++;
              c++;
          }
          while(c <= mid2 && idx2 < m) {
              if(c == mid1) ans1 = arr2[idx2];
              if(c == mid2) ans2 = arr2[idx2];
              idx2++;
              c++;
          }
          return (n + m) % 2? ans2 : (ans1 + ans2) / 2.0;
      }
  };