class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length ;
        int mindivisor = 1 ;
        int maxdivisor = maxi(nums) ;
        int ans = -1 ;
        while(mindivisor <= maxdivisor){
            int mid = mindivisor + (maxdivisor - mindivisor) /2 ;

            if(isPossible(nums, threshold, mid)){
                ans = mid ;
                maxdivisor = mid -1 ; // check for the smallest
            }
            else{
                mindivisor = mid + 1 ;
            }
        }
        return ans ;
        
    }
    public boolean isPossible(int[] arr , int threshold , int divisor){
        int maxsum = 0 ;
        for(int c : arr){
            maxsum += (c + divisor - 1) / divisor ; 

            if(maxsum > threshold){
                return false ;
            }
        }
        return (maxsum<=threshold) ;
    }
    public int maxi(int[] arr){
        int n = arr.length ;
        int maxvalue = arr[0];
        for(int c: arr){
            maxvalue = Math.max(maxvalue , c) ;
        }
        return maxvalue ; 
    }

}