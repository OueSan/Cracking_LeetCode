class Solution {
public:
    long long sum(vector<int> &nums , int divisor , int threshold ){
        long long sum1=0;
        for(int i=0;i<nums.size();i++){
            sum1 += (nums[i] + divisor - 1) / divisor;
            /*if(sum1>thre8shold){
                return -1;*/
            
        }
        return sum1;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        int max1 = nums[0];
        int divisor=-1;
        for(int i=1;i<nums.size();i++){
            if(nums[i]>max1){
                max1 = nums[i];
            }
        }
        int s= 1;
        int e = max1;
        while(s<=e){
            int mid = s+(e-s)/2;
            int result = sum(nums , mid ,threshold );
            if(result <= threshold){
                divisor = mid;
                e = mid-1;
            }
            else {
                s = mid+1;
            }

        }
        return divisor;

    }
};