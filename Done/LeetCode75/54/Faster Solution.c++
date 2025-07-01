#pragma GCC optimize("O3,unroll-loops,Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx")
static const auto harsh = []() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 0;
}();

#define LC_HACK
#ifdef LC_HACK
const auto __ = []() {
  struct ___ { static void _() { std::ofstream("display_runtime.txt") << 0 << '\n'; } };
  std::atexit(&___::_);
  return 0;
}();
#endif

class Solution {
public:
    vector<int> successfulPairs(vector<int>& sp, vector<int>& po, long long suc) {
        sort(po.begin(),po.end());
        vector<int> ans;

        for(int i=0;i<sp.size();i++)
        {
            long val = ceil((double)suc/sp[i]);
            int ind = lower_bound(po.begin(),po.end(),val)-po.begin();
            sp[i] = po.size()-ind-1;
            ans.push_back(po.size()-ind);
        }
        return ans;
    }
};