class Solution {
public:
  long long int zero(long long int n){
      long long int ans=0;
        while(n!=0){
           ans+=n/5;
           n=n/5;
        }  
        return ans;
    }
    int preimageSizeFZF(int k) {
       long long int l=0, h=static_cast<long long int>(k + 1) * 5 - 1;
        while(l<=h){
           long long int mid=l+(h-l)/2;
           long long int te=zero(mid);
            if(te<k) l=mid+1; // if no of zeroes are less than k
            else if(te>k) h=mid-1; // if no of zeroesare more than k
            else if(te==k) return 5;
        }
        return 0; // if no exact k zeroes are found return zero.
    }
};