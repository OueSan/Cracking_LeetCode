class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        int lo=1, hi=2000000000;
        long long A=a, B=b, C=c;
        // Using gcd(a,b)*lcm(a,b) = a*b
        long long lcmAB = A*B/__gcd(A,B), lcmBC = B*C/__gcd(B,C), lcmAC = A*C/__gcd(A,C), lcmABC=lcmAB*C/__gcd(lcmAB,C);
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int nBeforeMid = 1LL*mid/a + mid/b + mid/c - mid/lcmAB - mid/lcmBC - mid/lcmAC + mid/lcmABC;
            if(nBeforeMid == n){
                int remA = mid % a, remB = mid % b, remC = mid % c;
                if(remA == 0 || remB == 0 || remC == 0) return mid;
                else return mid - min({remA, remB, remC});
            }
            else if(nBeforeMid > n) hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;
    }
};