class Solution {
  public int hIndex(int[] citations) {
      int n = citations.length;
      int left = 0, right = n - 1;

      while (left <= right) {
          int mid = left + (right - left) / 2;

          // Check if citations[mid] can be an h-index
          if (citations[mid] >= n - mid) {
              right = mid - 1; // Try for a larger h-index
          } else {
              left = mid + 1; // Increase citation count requirement
          }
      }

      // The number of papers with at least `n - left` citations
      return n - left; 
  }
}