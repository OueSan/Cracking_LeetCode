class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        // Add the elements from nums1 to set1
        unordered_set<int> set1(nums1.begin(), nums1.end());

        // Search for each element of nums2 in set1
        // Return the first common element found
        for (int num : nums2) {
            if (set1.contains(num)) {
                return num;
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }
};