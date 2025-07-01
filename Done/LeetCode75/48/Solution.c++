class Solution {
  public:
      int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
          int m = maze.size(), n = maze[0].size();
          // Step 1: Initialize distance array with a large value (infinity)
          // This ensures unvisited cells have a high initial distance
          vector<vector<int>> distance(m, vector<int>(n, 1e8));
          // Step 2: Set distance of the entrance cell to 0 and push to priority queue
          distance[entrance[0]][entrance[1]] = 0;
          priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
          pq.push({0, {entrance[0], entrance[1]}});
          // Step 3: Define movement directions - Up, Right, Down, Left
          vector<pair<int, int>> directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
          // Step 4: Apply Dijkstra's algorithm to calculate minimum distance from entrance
          while (!pq.empty()) {
              int dist = pq.top().first;
              int i = pq.top().second.first;
              int j = pq.top().second.second;
              pq.pop();
              // Explore all 4 directions from the current cell
              for (auto dir : directions) {
                  int ni = i + dir.first;
                  int nj = j + dir.second;
                  // Step 5: Check if the neighboring cell is within bounds and open ('.')
                  if (ni >= 0 && ni < m && nj >= 0 && nj < n && maze[ni][nj] == '.') {
                      // Step 6: Relaxation step - update distance if a shorter path is found
                      if (dist + 1 < distance[ni][nj]) {
                          distance[ni][nj] = dist + 1;
                          pq.push({distance[ni][nj], {ni, nj}});
                      }
                  }
              }
          }
          // Step 7: Find the minimum distance to any exit on the boundary
          int minDist = 1e8;
          for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  // Check if the cell is on the boundary and not the entrance itself
                  if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && !(i == entrance[0] && j == entrance[1])) {
                      minDist = min(minDist, distance[i][j]);
                  }
              }
          }
          // Step 8: Return minimum distance if reachable, otherwise return -1
          return minDist == 1e8 ? -1 : minDist;
      }
  };