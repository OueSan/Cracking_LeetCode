class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int pos=0,step=0,st=1,end=target;

        long sum=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            sum=(long)mid*(mid+1)/2;

            if(sum>=target){
                pos=(int)sum;
                step=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }

        while((pos-target)%2!=0){
            step++;
            pos+=step;
        }

        return step;
    }
}