// Runtime: 3 ms, faster than 96.43% of C++ online submissions for Intersection of Two Arrays II.
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        // If the size of nums1 is greater than nums2, swap them...
        if(nums1.size() > nums2.size()) {
            swap(nums1, nums2);
        }
        // Create a hashmap to find out the intersection of two arrays...
        unordered_map<int,int> map;
        // Store the count of each element of one array using the Hash map...
        for(auto val: nums1) {
            map[val]++;
        }
        int idx = 0;
        // Traverse through the nums2 array....
        for(auto val: nums2) {
            // For each element in nums2, check if count of that element in nums1 is positive or not...
            // If count of nums2[idx] in array nums1 is positive, then add this element(nums2[idx]) in result array...
            if(map[val] > 0){
                nums1[idx++] = val;
                // Decrease the count of this element in Hash map.
                --map[val];
            }
        }
        return vector<int>(nums1.begin(), nums1.begin()+idx);
    }
};