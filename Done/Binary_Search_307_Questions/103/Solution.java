class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int candidateNumber = 1; candidateNumber <= n; ++candidateNumber) {
            if (candidateNumber == findNumberOfNums(nums, n, candidateNumber)) {
                return candidateNumber;
            }
        }

        return -1;
    }

    private int findNumberOfNums(int[] nums, int n, int curNum) {
        int left = 0, right = n - 1;
        int firstIndex = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= curNum) {
                firstIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n - firstIndex;
    }
}