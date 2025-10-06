class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        set<pair<int, vector<int>>> st;
        pair<int,vector<int>> vec;
        for(int i=0;i<mat.size();i++){
            vec.second.push_back(0);
            vec.first+=mat[i][0];
        }
        st.insert(vec);
        if(k==1){
            return vec.first;
        }
        while(k>1){
            auto it = st.begin();
            pair<int, vector<int>> a = (*it);
            st.erase(st.begin());
            for(int i = 0; i<mat.size();i++){
                if(a.second[i] +1 < mat[i].size()){
                    a.first += mat[i][a.second[i] + 1] - mat[i][a.second[i]];
                    a.second[i]++;
                    st.insert(a);
                    a.second[i]--;
                    a.first += mat[i][a.second[i]] - mat[i][a.second[i]+1];
                }
            }  
            k--;
        }
        auto temp = st.begin();
        int ans= (*temp).first;
        return ans;
    }
};