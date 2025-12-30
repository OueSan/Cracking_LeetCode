class Solution:
    def maxValue(self, events, k):
        events.sort()
        def dfs(i, lastEnd, k):
            if i == len(events) or k == 0:
                return 0
            take = 0
            if events[i][0] > lastEnd:
                take = events[i][2] + dfs(i + 1, events[i][1], k - 1)
            skip = dfs(i + 1, lastEnd, k)
            return max(take, skip)
        return dfs(0, -1, k)