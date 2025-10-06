import heapq

class Solution:
    def kthSmallest(self, mat: list[list[int]], k: int) -> int:
        prev = mat[0][:k]
        for row in mat[1:]:
            heap = []
            for i, val in enumerate(prev):
                heapq.heappush(heap, (val + row[0], i, 0))
            curr = []
            m, n = len(prev), len(row)
            for _ in range(min(k, m*n)):
                s, i, j = heapq.heappop(heap)
                curr.append(s)
                if j + 1 < len(row):
                    heapq.heappush(heap, (prev[i] + row[j+1], i, j+1))
            prev = curr
        return prev[k-1]