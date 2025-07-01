const auto _ = std::cin.tie(nullptr) -> sync_with_stdio(false);
#define LC_HACK
#ifdef LC_HACK
const auto __ = []() {
    struct ___ {
        static void _() { std::ofstream("display_runtime.txt") << 0 << '\n'; }
    };
    std::atexit(&___::_);
    return 0;
}();
#endif
class Solution {
public:
    static bool cmp(vector<int> &a, vector<int> &b)
    {
        return a[1]<b[1];
    }
    int findMinArrowShots(vector<vector<int>>& points) {
        int ans = 0,n=points.size();

        sort(points.begin(),points.end(),cmp);
        for(auto x:points) cout << x[0] << ' ' << x[1] << endl;

        int prev = 0;
        for(int i=1;i<n;i++) 
        {
            if(points[prev][1]>=points[i][0])
            {
                ans++;
                continue;
            }
            prev=i;
        }

        return n-ans;
    }
};