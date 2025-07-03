int dp[9][2];
class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        int ans = 0;
        for(long long i=10, j=1; i<=n; i*=10, j++) {
            ans += binpow(digits.size(), j);
        }
        memset(dp, -1, sizeof(dp));
        ans += fun(digits, 0, to_string(n), true);
        return ans;
    }

    int fun(vector<string>& digits, int idx, const string& str, bool tight) {
        if(idx >= str.size()) {
            return 1;
        }
        if(dp[idx][tight] == -1) {
            int cur = 0;
            for(auto& e : digits) {
                if(tight and e[0] > str[idx]) break;
                cur += fun(digits, idx+1, str, tight and e[0] == str[idx]);
            }
            dp[idx][tight] = cur;
        }
        return dp[idx][tight];
    }

    long long binpow(long long a, long long b) {
        long long ans = 1;
        while(b > 0) {
            if(b % 2 == 1) {
                ans = ans * a;
            }
            a = a*a;
            b >>= 1;
        }
        return ans;
    }
};