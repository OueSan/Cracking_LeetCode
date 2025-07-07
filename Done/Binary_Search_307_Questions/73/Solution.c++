
class Solution {
public:
    int findInMountainArray(int target, MountainArray &mountainArr) {
        int length = mountainArr.length();

        auto findTarget = [&](int left, int right, int target, bool isUpside) {
            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = mountainArr.get(mid);

                if (midVal == target) {
                    return mid;
                }

                if (isUpside) {
                    if (target > midVal) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (target > midVal) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return -1;
        };

        auto findPeak = [&]() {
            int left = 0;
            int right = length - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        };

        int peakIndex = findPeak();

        int result = findTarget(0, peakIndex, target, true);
        if (result != -1) {
            return result;
        }

        return findTarget(peakIndex + 1, length - 1, target, false);        
    }
};