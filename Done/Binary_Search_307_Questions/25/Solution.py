class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        r, c = len(matrix), len(matrix[0])
        m = [[0] * (c + 1) for _ in range(r + 1)]
        for i in range(r):
            if k in matrix[i]:
                return k
            m[i + 1] = [0] + list(accumulate(matrix[i]))
            for j in range(c + 1):
                m[i + 1][j] += m[i][j]
        res = -inf
        for down in range(1, r + 1):
            for up in range(down):
                arr = []
                for i in range(c + 1):
                    s = m[down][i] - m[up][i]
                    p = bisect_left(arr, s)
                    if len(arr) > p:
                        res = max(res, k - arr[p] + s)
                        if res == k: 
                            return res
                    insort(arr, s + k)
        return res