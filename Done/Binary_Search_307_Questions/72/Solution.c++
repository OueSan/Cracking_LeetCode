class Solution {
public:
    string help(string& s, int m) {
        if(m == 0) return "";
        int d = 256, pri = 1e9+7, n = s.size();

        long long h = 1;
        for(int i = 0; i < m - 1; i++) h = (h * d) % pri;

        long long hash = 0;
        for(int i = 0; i < m; i++) hash = (hash * d + s[i]) % pri;

        unordered_map<long long, vector<int>> mp;
        mp[hash] = {0};

        for(int i = 1; i <= n - m; i++) {
            hash = (d * (hash - s[i - 1] * h % pri + pri) + s[i + m - 1]) % pri;
            if(hash < 0) hash += pri;

            if(mp.find(hash) != mp.end()) {
                for(auto j : mp[hash]) 
                    if(s.substr(j, m) == s.substr(i, m)) return s.substr(i, m);
            }

            mp[hash].push_back(i);
        }

        return "";
    }

    string longestDupSubstring(string s) {
        int l = 1, r = s.size() - 1;
        string ans;

        while(l <= r) {
            int mid = (l + r) / 2;
            string t = help(s, mid);

            if(!t.empty()) {
                if(t.size() > ans.size()) ans = t;
                l = mid + 1;
            } else  r = mid - 1;
        }

        return ans;
    }
};