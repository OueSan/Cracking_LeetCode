class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        nums[1:] = sorted(nums[1:])
        return sum(nums[:3])