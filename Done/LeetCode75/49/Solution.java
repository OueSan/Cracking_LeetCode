import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all initial rotten oranges to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges to begin with
        if (fresh == 0) return 0;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int minutes = 0;

        // Step 2: BFS to infect adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}