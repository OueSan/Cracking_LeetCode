class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        n = len(intervals)
        intervals_with_idx = sorted([(interval, i) for i, interval in enumerate(intervals)], key=lambda x: x[0][0])
        
        sorted_starts = [interval[0][0] for interval in intervals_with_idx]
        
        def search(end):
            left, right = 0, n - 1
            while left <= right:
                mid = (left + right) // 2
                if sorted_starts[mid] < end:
                    left = mid + 1
                else:
                    right = mid - 1
            return left if left < n else -1
        
        res = [-1] * n
        for i, (start, end) in enumerate(intervals):
            pos = search(end)
            if pos != -1:
                res[i] = intervals_with_idx[pos][1]
        return res