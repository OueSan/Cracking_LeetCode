class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if(intervals.length == 1)
            if(intervals[0][0] == intervals[0][1])
                return new int[] { 0};
            else
                return new int[] {-1};
        int[] result = new int[intervals.length];
        for(int i = 0 ; i < intervals.length ; i++){
            // System.out.println("hi");
            result[i] = helper(intervals , 0 , intervals.length - 1 , intervals[i][1] );
        }
        return result;
    }
    public int helper(int[][] arr , int st , int end , int target){
        int mid = st + (end - st) / 2;
        // System.out.println(st + " " + mid + " " + end);
        if(end < st){
           if (st >= arr.length) return -1;
            if ((end < 0 && arr[st][0] < target) || (arr[st][0] < target))
                return - 1;
            if(st == arr.length)
                return 0;
            else if(arr[st][0]<target)
                return -1;
            else
                return st;
        }
        if(arr[mid][0] == target)
            return mid;
        // if(arr[st][0] == arr[mid][0] && arr[end][0] == arr[mid][0])
        //     return helper(arr , st + 1 , end -1 , target);
        else if(arr[st][0] <= arr[end][0]){
            if(arr[mid][0] > target)
                return helper(arr , st , mid - 1 , target);
            else
                return helper(arr , mid + 1 , end , target);
        }
        else if(arr[st][0] < arr[mid][0])
            if(arr[st][0] <= target && target < arr[mid][0])
            {
                System.out.println("in");
                return helper(arr , st , mid - 1 , target);
            }
            else
            {
                                System.out.println("out");
                return helper(arr , mid + 1 , end , target);
            }
        else
            if(arr[mid][0] < target && target <= arr[end][0])
                return helper(arr , mid + 1 , end , target);
            else
                return helper(arr , st , mid - 1 , target);
    }
}