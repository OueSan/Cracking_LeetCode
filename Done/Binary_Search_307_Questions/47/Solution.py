class Solution:
    def search(self, nums: list[int], target: int) -> int:
        mid = len(nums) // 2
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right + 1) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1