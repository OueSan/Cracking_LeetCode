from collections import defaultdict

class Solution:
    def longestDupSubstring(self, s: str) -> str:
        n = len(s)
        mod = 100000000001
        checkSum = [0] * n

        for i, ch in enumerate(s):
            checkSum[i] = ord(ch)
            if i > 0:
                checkSum[i] = (checkSum[i] + checkSum[i - 1]) % mod

        beg, end = 0, n - 1
        self.result = ""
        self.count = 0

        def Check(mid):
            dictionary = defaultdict(list)
            for i in range(mid - 1, n):
                prefix = checkSum[i - mid] if i - mid >= 0 else 0
                res = (checkSum[i] - prefix) % mod
                temp = s[i - mid + 1 : i + 1]
                if res in dictionary and temp in dictionary[res]:
                    if self.count < mid:
                        self.count = mid
                        self.result = temp
                    return True
                dictionary[res].append(temp)
            return False

        while beg <= end:
            mid = (beg + end) >> 1
            if Check(mid):
                beg = mid + 1
            else:
                end = mid - 1

        return self.result