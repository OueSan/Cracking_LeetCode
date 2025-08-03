class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        sort(products.begin(), products.end());
        vector<vector<string>> sol(searchWord.size());
        for (auto & product : products) {
            // see the length of the prefix same as searchword
            int prefix_length = searchWord.size();
            for (int i = 0; i < searchWord.size(); i++) {
                if (i >= product.size() || searchWord[i] != product[i]) {
                    prefix_length = i;
                    break;
                }
            }
            // add to solution vector
            for (int i = 0; i < prefix_length; i++) {
                if (sol[i].size() < 3) {
                    sol[i].push_back(product);
                }
            }
        }
        return sol;
    }
};