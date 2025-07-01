class SegmentTree {
private:
    int tree_size;
    vector<int> tree;

    void update(int li, int ri, int ni, int val) {
        if(ri - li == 1) {
            tree[ni]++;
            return;
        }

        int m = (li + ri) >> 1;

        if(val < m)
            update(li, m, ni * 2 + 1, val);

        else
            update(m, ri, ni * 2 + 2, val);

        tree[ni] = tree[ni * 2 + 1] + tree[ni * 2 + 2];
    }

    int query(int l, int r, int li, int ri, int ni) {
        if(l >= ri || r <= li)
            return 0;

        if(l <= li && r >= ri)
            return tree[ni];

        int m = (li + ri) >> 1;
        return query(l, r, li, m, ni * 2 + 1) + query(l, r, m, ri, ni * 2 + 2);
    }

public:
    SegmentTree(int n) {
        tree_size = 1;

        while(tree_size < n)
            tree_size <<= 1;

        tree = vector<int>(tree_size << 1);
    }

    void update(int val) {
        update(0, tree_size, 0, val);
    }

    int query(int l, int r) {
        return query(l, r + 1, 0, tree_size, 0);
    }
};

class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> num_idx;

        vector<int> sorted = nums;
        sort(begin(sorted), end(sorted));

        for(int i = 0; i < n; ++i)
            num_idx[sorted[i]] = i;

        SegmentTree seg_tree(n);
        vector<int> count(n);
        
        for(int i = n - 1; i >= 0; --i) {
            int index_of_number = num_idx[nums[i]];
            count[i] = seg_tree.query(0, index_of_number - 1);
            seg_tree.update(index_of_number);
        }
        
        return count;
    }
};