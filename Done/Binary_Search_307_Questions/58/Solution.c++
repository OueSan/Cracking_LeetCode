class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        // first store char of the s and their respective index in map
        unordered_map<char,vector<int>> mp;
        int k=0; // for index
        for(auto it:s) 
            mp[it].push_back(k++);

        int count = 0;
        for(int i=0;i<words.size();++i){
            string curr = words[i];
            //we need to consider the char after the curr index
            int latest =-1;
            for(int j=0;j<curr.size();++j){
                // first we need to find the current char in the map and get its index
                // for a particular char in the mp, we have a vector, so we need to iterate through the vector
                auto it = upper_bound(mp[curr[j]].begin(),mp[curr[j]].end(),latest);
                if(it == mp[curr[j]].end()) break; //if we dont find the char after the lastet value, we break
                latest = *it;
                if(j == curr.size()-1) count++;
            }
        }
        return count;
    }
};