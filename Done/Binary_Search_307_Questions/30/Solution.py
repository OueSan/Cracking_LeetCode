class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        array = []
        heapify(array)
        count = 0
        for i in range(len(matrix)):
            for j in range(len(matrix)):
                heappush(array, matrix[i][j])
        while count < k - 1:
            heappop(array)
            count += 1

        return heappop(array)
        
        