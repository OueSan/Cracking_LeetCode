class Solution {
  public int peakIndexInMountainArray(int[] arr) {
      int start = 0;
      int end = arr.length-1;

      while(start < end){
          int mid = start + (end - start)/2;

          if(arr[mid] > arr[mid+1]){
          //if true you are in the descending part of the array
              end = mid;
          }
          
          else if(arr[mid] < arr[mid + 1]){
          //if true you are in the ascending part
              start = mid +1;
          }
      }
      return start;
  }
}