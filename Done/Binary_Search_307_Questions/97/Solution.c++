#include <vector>
#include <algorithm>
#include <utility>

class Solution {
private:
    static const int MODULUS = 1000000007;
    long long maxSubarraySum = 0;
    long long minSubarraySum = 0;

    std::pair<int, long long> countAndSumSubarrays(const std::vector<int>& array, long long threshold) {
        int count = 0;
        long long totalSum = 0, currentWindowSum = 0, runningSum = 0;
        int size = array.size();

        for (int start = 0, end = 0; end < size; ++end) {
            runningSum += static_cast<long long>(array[end]) * (end - start + 1);
            currentWindowSum += array[end];
            while (currentWindowSum > threshold) {
                runningSum -= currentWindowSum;
                currentWindowSum -= array[start++];
            }
            count += end - start + 1;
            totalSum += runningSum;
        }
        return {count, totalSum};
    }

    long long calculateSumOfFirstKSubarrays(const std::vector<int>& array, int k) {
        long long low = minSubarraySum, high = maxSubarraySum;
        while (low < high) {
            long long mid = low + (high - low) / 2;
            if (countAndSumSubarrays(array, mid).first < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        auto [count, sum] = countAndSumSubarrays(array, low);
        return sum - low * (count - k);
    }

public:
    int rangeSum(std::vector<int>& nums, int n, int left, int right) {
        minSubarraySum = *std::min_element(nums.begin(), nums.end());
        maxSubarraySum = std::accumulate(nums.begin(), nums.end(), 0LL);

        long long result = (calculateSumOfFirstKSubarrays(nums, right) % MODULUS - 
                            calculateSumOfFirstKSubarrays(nums, left - 1) % MODULUS + 
                            MODULUS) % MODULUS;
        return static_cast<int>(result);
    }
};