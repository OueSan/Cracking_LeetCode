class Solution {
  public String predictPartyVictory(String s ) {
  return recursion(s.toCharArray(), s.length(), 0);
}

private static String recursion(char[] s, int leng, int state) {
  int newLeng = 0;
  for( int i = 0 ; i < leng; i++) {
    if(s[i] == 'R') {
      if(state >= 0) {
        s[newLeng++] = 'R';
      }
      state++;
    }
    else {
      if(state <= 0) {
        s[newLeng++] = 'D';
      }
      state--;
    }
  }
  if(Math.abs(state) >= newLeng) {
    return (state >= 0 ) ? "Radiant" : "Dire";
  }
  
  return recursion(s, newLeng, state);
}
}