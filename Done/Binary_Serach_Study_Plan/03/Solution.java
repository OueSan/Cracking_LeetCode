class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      int low = 0;
      int high = letters.length - 1;

      while (low <= high) {
          int middle = (low + high) / 2;
          char guess = letters[middle];

          if (guess <= target) {
              low = middle + 1;
          } else {
              high = middle - 1;
          }
      }

      if (low < letters.length) {
          return letters[low];
      } else {
          return letters[0];
      }
  }
}
