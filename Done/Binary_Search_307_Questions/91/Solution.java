public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        if (m == 1) return mat[0][k - 1];

        int[] ans = kSmallestSumPairs(mat[0], mat[1], k);
        for (int r = 2; r < m; r++) {
            ans = kSmallestSumPairs(ans, mat[r], k);
        }
        return ans[k - 1];
    }

    private int[] kSmallestSumPairs(int[] arr1, int[] arr2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int c = 0; c < Math.min(arr1.length, k); c++) {
            minHeap.offer(new int[]{arr1[c] + arr2[0], c, 0});
        }

        List<Integer> ansList = new ArrayList<>();
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            ansList.add(current[0]);
            if (current[2] + 1 < arr2.length) {
                minHeap.offer(new int[]{arr1[current[1]] + arr2[current[2] + 1], current[1], current[2] + 1});
            }
            k--;
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}