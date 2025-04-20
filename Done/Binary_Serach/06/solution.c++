class Solution 
{
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) 
    {
        vector<int> ans;
        map<int, int> m { {INT_MAX, -1} };

        for(int i=0; i<intervals.size(); i++)
            m[intervals[i][0]] = i; // < x[0], index >

        for(auto &arr : intervals)
            ans.push_back( m.lower_bound(arr[1])->second );

        return ans;
    }
};