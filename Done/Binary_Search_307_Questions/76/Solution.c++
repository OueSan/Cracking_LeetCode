class Solution {
private:
    int smallcnt(string& word){
        int count = 0, minChar = 'z';
        for(int j = 0, len = word.length(); j < len; ++j){
            if(word[j] < minChar){
                minChar = word[j];
                count = 1;
            }
            else if(word[j] == minChar) ++count;
        }
        return count;
    }
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        int m = words.size();
        int freq[12] = {0};
        for(int i = 0; i < m; ++i) ++freq[smallcnt(words[i])];
        for(int i = 10; i > 0; --i) freq[i - 1] += freq[i];

        int n = queries.size();
        vector<int> res(n);
        for(int i = 0; i < n; ++i){
            int f = smallcnt(queries[i]);
            res[i] = freq[f + 1];
        }
        return res;
    }
};