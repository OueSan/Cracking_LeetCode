class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        low, high = max(nums), sum(nums)
        ans = high
        while low <= high:
            mid = (low + high) // 2
            if self.is_feasible(nums, mid, k):
                ans = mid
                high = mid - 1
            else:
                low = mid + 1
        return ans
    
    def is_feasible(self, nums, max_sum, k):
        count = 1
        current_sum = 0
        for num in nums:
            current_sum += num
            if current_sum > max_sum:
                count += 1
                current_sum = num
                if count > k:
                    return False
        return True