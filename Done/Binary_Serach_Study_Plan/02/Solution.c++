#include <vector>

class Solution {
public:
    int searchInsert(std::vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int guess = nums[middle];

            if (guess == target) {
                return middle;
            }

            if (guess > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }
};
