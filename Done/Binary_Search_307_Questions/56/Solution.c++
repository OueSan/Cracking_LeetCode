class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int t = grid.size();

        priority_queue<pair<int, pair<int, int>>, 
                       vector<pair<int, pair<int, int>>>, 
                       greater<pair<int, pair<int, int>>>> q; //Min heap

        vector<vector<bool>> visi(t, vector<bool>(t, false));  //visited  array

        
        q.push({grid[0][0], {0, 0}});
        visi[0][0] = true;

       
        int drow[] = {0, 1, 0, -1};
        int dcol[] = {1, 0, -1, 0};

        while (!q.empty()) {
            auto [time, pos] = q.top();             //q.top()={minimum of max time,{row,col}}
            int row = pos.first, col = pos.second;
            q.pop();

            //if reaches last grid then return value
            if (row == t - 1 && col == t - 1) {
                return time;
            }
           
           // check all four adjacent blocks
            for (int i = 0; i < 4; i++) {       
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < t && ncol < t && !visi[nrow][ncol]) {
                    visi[nrow][ncol] = true;
                    q.push({max(time, grid[nrow][ncol]), {nrow, ncol}});
                }
            }
        }

        return -1;  
    }
};