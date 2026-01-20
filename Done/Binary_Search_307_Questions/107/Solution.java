class Solution {
    public int minOperations(int[] nums, int x) {
        
        /*equivalently u keep one middle subarray
        let total=sum(nums);
        so targetSum=total-x;
        reframe:
        find the longest subarray having sum=targetSum;
        return n-longestLen;
        */

        int n=nums.length;

        long total=0L;
        total=Arrays.stream(nums).asLongStream().sum();
        //int total=Arrays.stream(nums).sum();
        long target=total-x;
        if(target==0)
        {
            return n;
        }
        if(target==-1)
        {
            return -1;//since 1 <= nums[i] <= 10^4

        }

        long curSum=0L;
        int left=0;
        int longest=-1;
        for(int right=0;right<n;right++)
        {
            curSum+=nums[right];
            while(left<=right && curSum>target)
            {
                
                curSum-=nums[left];
                left++;
            }
            if(curSum==target)
            {
                longest=Math.max(longest,right-left+1);
            }

        }
        return longest==-1?-1:n-longest;


    }
}