class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        l = 0
        r = len(numbers) -1

        while l < r: 
            _sum = numbers [l] + numbers [r]
            if _sum == target:
                return [l+1, r+1]
            
            if _sum > target:
                r-= 1
            else:
                l+= 1
        return []
