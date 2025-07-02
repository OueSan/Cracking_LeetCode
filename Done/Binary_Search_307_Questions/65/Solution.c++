class Solution {
public:
    int superEggDrop(int k, int n) {
        // k eggs
        // n floors
        vector<int> dp(k+1, 0);
        int attempts = 0;
        while(dp[k] < n){
            attempts++;
            for(int i=k; i>0; i--)
                dp[i] += 1 + dp[i-1];
        }
        return attempts;
    }
};