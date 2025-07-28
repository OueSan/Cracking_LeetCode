
class Solution {
public:
    vector<vector<int>> findSolution(CustomFunction& customfunction, int z) {
        vector<vector<int>>ans;
        
        for(int i=1;i<=1000;i++)
        {
            int left=1,right=1000;
            
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(customfunction.f(i,mid)==z)
                {
                    vector<int>temp;
                    temp.push_back(i);
                    temp.push_back(mid);
                    ans.push_back(temp);
                    break;
                }
                else if(customfunction.f(i,mid)>z)
                    right=mid-1;
                else
                    left=mid+1;
            }
            if(customfunction.f(i,1)>z)
                break;
        }
        return ans;
    }
};