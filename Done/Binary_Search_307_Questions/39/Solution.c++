class Solution {
public:
    vector<int> v;
    vector<vector<int>> rects;
    
	// [ 4,5,4,6 ] ( rectangle with height 0 or width 0 but this also contains 2 points )
    int cntPoints(vector<int>& r) {
        return (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
    }
    
    Solution(vector<vector<int>> rect) {
        rects = rect;
        int totalPts=0;
        for (auto r: rects) {
            totalPts+=cntPoints(r);
            v.push_back(totalPts);
        }
    }
    
    vector<int> pick() {
        // picking a random reactangle in rects
        int pt = rand() % v.back();  // v.back is totalPts
        // pt is one of that Total points
        int idx = upper_bound(v.begin(), v.end(), pt) - v.begin();
        // idx is index of rectangle in which that pt exist

        // picking a random point in rects[idx]
        vector<int> r = rects[idx];
        int x = rand() % (r[2] - r[0] + 1) + r[0];  // pick x cords for pt from  rect 
        int y = rand() % (r[3] - r[1] + 1) + r[1];  // pick y cords for pt from  rect 
        return { x, y };
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(rects);
 * vector<int> param_1 = obj->pick();
 */