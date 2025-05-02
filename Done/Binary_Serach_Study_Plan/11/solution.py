class Solution:
    def findMin(self, nums: list[int]) -> int:
        for n in range(1, len(nums)):
            if nums[n] < nums[n - 1]:
                return nums[n]
        return min(nums)