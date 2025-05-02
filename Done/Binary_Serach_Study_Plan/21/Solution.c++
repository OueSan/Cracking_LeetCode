class Solution {
  public:
      int peakIndexInMountainArray(vector<int>& arr) {
          if(arr[0]>arr[1]) return arr[0];
          if(arr[arr.size()-2]<arr[arr.size()-1]) return arr[arr.size()-1];
          int low = 1, high = arr.size()-2;
          while(low<=high)
          {
              int mid = low + (high - low)/2;
              if(arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1])
              {
                  return mid;
              }
              else if(arr[mid]<arr[mid+1])
              {
                  low = mid + 1;
              }
              else if(arr[mid]<arr[mid-1])
              {
                  high= mid - 1;
              }
          }
          return high;
      }
  };