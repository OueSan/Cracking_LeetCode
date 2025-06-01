class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        #Initialize N to get len(grid)
        N = len(grid)
        #Initialize a visit set that takes (0, 0) as tuple as default
        visit = set((0, 0))
        #Initialize minH array that takes [[grid[0][0], 0, 0]] as default
        minH = [[grid[0][0], 0, 0]]
        #Initialize directions to [[0, 1], [1, 0], [0, -1], [-1, 0]] to iterate directions in the input grid
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        #Iterate while minH
        while minH:
            #Initialize t, r, c to popped values from min heap minH
            t, r, c = heapq.heappop(minH)

            #Check if r == N - 1 and c == N - 1
            if r == N - 1 and c == N - 1:
                #return t as we reached bottom right corner of grid
                return t

            #Iterate in directions for dr, dc
            for dr, dc in directions:
                #Initialize neiR, neiC to r + dr, c + dc as these will be the coordinates of neighbouring positions
                neiR, neiC = r + dr, c + dc

                #Check if neiR and neiC are inbounds or if they are already in visit set
                if (neiR < 0 or neiC < 0 or neiR == N or neiC == N or (neiR, neiC) in visit):
                    #If true, continue and skip
                    continue

                #Add (neiR, neiC) to visit
                visit.add((neiR, neiC))
                #Push [max(t, grid[neiR][neiC]), neiR, neiC] to minH
                heapq.heappush(minH, [max(t, grid[neiR][neiC]), neiR, neiC]) 