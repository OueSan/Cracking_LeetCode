class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        n = len(events)
        events.sort(key = lambda x: x[1])
        ends = [e[1] for e in events]
        dps = []
        for i, (start, end, value) in enumerate(events):
            last_attend_index = bisect.bisect_left(ends, start) - 1
            new_dp = dps[i - 1][:] if i > 0 else [0] * k
            if value > new_dp[0]:
                    new_dp[0] = value
            if last_attend_index >= 0:
                dp = dps[last_attend_index]
                for j in range(1, k):
                    if dp[j - 1] == 0:
                        break
                    new_value = dp[j - 1] + value
                    if new_value > new_dp[j]:
                        new_dp[j] = new_value
            dps.append(new_dp)
        return max(dps[n - 1])