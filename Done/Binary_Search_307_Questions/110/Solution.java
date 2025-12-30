class Solution {
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(target[i], i);
        }

        int[] seq = new int[arr.length];
        int m = 0;
        for (int x : arr) {
            Integer p = pos.get(x);
            if (p != null) {
                seq[m++] = p;
            }
        }

        int[] tail = new int[m];
        int len = 0;
        for (int i = 0; i < m; i++) {
            int x = seq[i];
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tail[mid] < x) l = mid + 1;
                else r = mid;
            }
            tail[l] = x;
            if (l == len) len++;
        }

        return n - len;
    }
}