class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        boolean[] aval = new boolean[10];

        String num = Integer.toString(n);
        n = num.length();

        for(String it : digits){
            aval[it.charAt(0)-'0'] = true;
        }

        int[][] dp = new int[n+1][2];

        for(int[] it : dp){
            Arrays.fill(it, -1);
        }

        int ans = 0;

        for(int i = n;i > 0;i--){
            ans += f(dp, aval, num, i, (i == n) ? 1 : 0);
        }

        return ans;
    }

    private int f(int[][] dp, boolean[] aval, String num, int n, int tight){
        if(n == 0){
            return 1;
        }

        if(dp[n][tight] != -1){
            return dp[n][tight];
        }

        int ans = 0;

        if(tight == 1){
            int mxAllowed = num.charAt(num.length()-n) - '0';
            for(int i = 0;i < 10;i++){
                if(aval[i]){
                    if(i < mxAllowed){
                        ans += f(dp, aval, num, n-1, 0);
                    }
                    else if(i == mxAllowed){
                        ans += f(dp, aval, num, n-1, 1);
                    }
                }
            }
        }
        else{
            for(int i = 0;i < 10;i++){
                if(aval[i]){
                    ans += f(dp, aval, num, n-1, 0);
                }
            }
        }

        return dp[n][tight] = ans;
    }
}