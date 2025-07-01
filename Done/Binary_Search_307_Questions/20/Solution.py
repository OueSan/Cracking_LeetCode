
class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:

        ls = SortedList()
        ans = d = 0

        for num in reversed(nums):
            d += num
            ls.add(num - d)
            l = ls.bisect_left(lower - d)
            r = ls.bisect_right(upper - d)
            ans += r - l

        return ans