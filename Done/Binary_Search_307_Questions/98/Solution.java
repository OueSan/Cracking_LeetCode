class Solution {
    public int closestToTarget(int[] arr, int target) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            ret = Math.min(ret, Math.abs(arr[i] - target));
            for (int j = i-1; j >= 0 && (arr[j] & arr[i]) != arr[j]; j--){
                arr[j] &= arr[i];
                ret = Math.min(ret, Math.abs(arr[j] - target));
            } 
        }
        return ret;
        
    }
}