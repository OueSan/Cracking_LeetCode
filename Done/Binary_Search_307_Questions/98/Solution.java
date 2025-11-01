class Solution {
    public int closestToTarget(int[] arr, int target) {
        SegTree sg = new SegTree(arr.length, arr);
        int ans = Integer.MAX_VALUE, n = arr.length;
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int x = sg.find(0, 0, n - 1, i, mid, arr[i]);
                ans = Math.min(Math.abs(x - target), ans);
                if (x <= target) {
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
        }

        return ans;
    }

    class SegTree {
        int[] seg;
        int[] arr;

        public SegTree(int n, int[] arr) {
            seg = new int[4 * n];
            this.arr = arr;
            build(0, 0, n - 1);
        }

        public void build(int i, int l, int r) {
            if (l == r) {
                seg[i] = arr[l];
                return;
            }
            int mid = l + (r - l) / 2;
            build(2 * i + 1, l, mid);
            build(2 * i + 2, mid + 1, r);
            seg[i] = seg[2 * i + 1] & seg[2 * i + 2];
        }

        public int find(int i, int tl, int tr, int l, int r, int ans) {
            // no overlap
            if (r < tl || l > tr) {
                return ans;
            }

            // full overlap
            if (l <= tl && tr <= r) {
                return seg[i] & ans;
            }
            // partial overlap
            int mid = tl + (tr - tl) / 2;
            if (r <= mid) {
                return find(2 * i + 1, tl, mid, l, r, ans);
            } else if (l > mid) {
                return find(2 * i + 2, mid + 1, tr, l, r, ans);
            }
            return find(2 * i + 1, tl, mid, l, r, ans) & find(2 * i + 2, mid + 1, tr, l, r, ans);
        }
    }
}