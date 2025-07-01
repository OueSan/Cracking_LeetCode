class Solution {
  public int maxVowels(String s, int k) {
      char[] text = s.toCharArray();
      int maxVowels = 0, currentVowelCount = 0;

      for (int i = 0; i < k; i++) {
          if (isVowel(text[i])) currentVowelCount++;
      }
      maxVowels = currentVowelCount;

      for (int i = k; i < text.length; i++) {
          if (isVowel(text[i])) currentVowelCount++;
          if (isVowel(text[i - k])) currentVowelCount--;
          maxVowels = Math.max(maxVowels, currentVowelCount);
      }
      return maxVowels;
  }
  private boolean isVowel(char c) {
      return "aeiou".indexOf(c) != -1;
  }
}