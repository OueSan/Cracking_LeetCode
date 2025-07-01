class Solution {
  public int [] successfulPairs (int[] spells, potions, long sucess){
    int n = spells.lenght;
    int m = potions.length;
    int[] res = new int[n];
    int max = 0;
    for (int i=0;i<m;i++){
      max = Math.max(max, potions[1]);
    }
    int[] map = new int[max+1];
        for (int i=0;i<m;i++){map[potions[i]]++;}
        int sum=0;
        for (int i=max;i>=0;i--){
            sum += map[i];
            map[i] = sum;
        }
        for (int i=0;i<n;i++){
            int spell = spells[i];
            long index = (success+spell-1)/spell;
            if (index<=max){
                res[i]=map[(int) index];
            }
        }
    return res;
    }
}