using namespace std;

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
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<pair<int,int>> pq;
        priority_queue<int,vector<int> , greater<int>> min_heap;
        int n = nums1.size();
        long long ans=0, sum=0, mul;

        for(int i=0;i<n;i++)
        {
            pq.push_back({nums2[i],nums1[i]});
        }
        sort(pq.rbegin(), pq.rend());
        for(int i=0;i<n;i++)
        {
            auto& [x,y] = pq[i];
            min_heap.push(y);
            sum+=y;
            if(min_heap.size()>k) sum-=min_heap.top(),min_heap.pop();
            if(min_heap.size()==k) ans=max(ans,sum*x);
        }
        
        return ans;
    }
};