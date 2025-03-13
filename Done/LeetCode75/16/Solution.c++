class Solution {

  static {
      for (int i = 0; i < 300; i++) maxVowels("",0);
  }

  public static int maxVowels(String s, int k) {
      char[] cs = s.toCharArray();
      int[] vowel = new int[26];
      vowel['a'-'a'] = 1;
      vowel['e'-'a'] = 1;
      vowel['i'-'a'] = 1;
      vowel['o'-'a'] = 1;
      vowel['u'-'a'] = 1;

      int vowels = 0;
      for (int i = 0; i < k; i++) {
          vowels += vowel[cs[i]-'a'];
      }

      if (vowels == k) return k;
      
      int maxVowels = vowels;
      for (int i = 0, j = k, n = cs.length; j < n; j++, i++) {
          vowels = vowels + vowel[cs[j]-'a'] - vowel[cs[i]-'a'];
          if (maxVowels < vowels) {
              maxVowels = vowels;
              if (maxVowels == k) break;
          }
      }
      
      return maxVowels;
  }
}