class Solution:
    def removeCoveredIntervals(self, A: List[List[int]]) -> int:
        A.sort(key=lambda x: (x[0], -x[1]))
        res = lo = 0

        for _, b in A:
            res += b > lo
            lo = max(lo, b)

        return res