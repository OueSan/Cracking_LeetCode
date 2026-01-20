class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        const int n = target.size();
        unordered_map<int,int> map;
        for(int i = 0; i < n; ++i) map[target[i]] = i;
        vector<int> stack;
        for(int i = 0, m = arr.size(); i < m; ++i){
            int num = arr[i];
            if(!map.count(num)) continue;
            int idx = map[num];
            if(stack.empty() || idx > stack.back()) stack.push_back(idx);
            else *lower_bound(stack.begin() , stack.end() , idx) = idx;
        }
        return n - stack.size();
    }
};