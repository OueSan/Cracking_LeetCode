class Solution {
public:
    int arrangeCoins(int n) {
        for(long i=2;;i++){
            long sum = (i*(i+1))/2;
            if(sum > n) return i-1;
            if(sum == n) return i;
        }
        return -1;
    }
};