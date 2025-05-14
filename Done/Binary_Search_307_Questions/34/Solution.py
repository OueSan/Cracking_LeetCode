class Solution:
    def arrangeCoins(self, n: int) -> int:
        left = 1
        right = n
        while left < right:
            mid = (right + left + 1) // 2
            if (1 + mid) * mid // 2 <= n:
                left = mid
            else:
                right = mid - 1
        return left