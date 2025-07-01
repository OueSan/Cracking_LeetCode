class Solution {
    public boolean isPerfectSquare(int num) {
        if(num ==0 || num == 1){
            return true;
        }

       long i =0;
       long j = num;
        
        while(i<=j){
            long mid = (i+j)/2;

            if (mid*mid == num) {
                return true;
            } else if (mid*mid < num){
                i = mid+1;
            } else if (mid*mid>num){
                j = mid-1;
            }
        }
        return false;
    }
}