class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
          vector<int>::iterator itr;
     vector<int>::iterator itr2;
     vector<int> found;
     for(int num : nums1) {
         itr2= find(found.begin(), found.end(), num);
         if(itr2 == found.end()) {
             itr= find(nums2.begin(), nums2.end(), num);
             if(itr !=nums2.end()) {
                 found.push_back(*itr);
             }
         }
     }
         return found;
    }
};