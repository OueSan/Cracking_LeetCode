class Solution {
private:
    int mergeSort(int s,int e,vector<long long>&sums,int lower,int upper){
        if(e-s<=1){
            return 0;
        }
        int mid=s+(e-s)/2;
        int count=mergeSort(s,mid,sums,lower,upper)+mergeSort(mid,e,sums,lower,upper);
        int j=mid;
        int k=mid;
        vector<long long> temp;
        for(int i=s;i<mid;i++){
            while(k<e&&(sums[k]-sums[i])<lower){
                k++;
            }
            while(j<e&&(sums[j]-sums[i])<=upper){
                j++;
            }
            count+=(j-k);
        }
        int i1=s;
        int i2=mid;
        while(i1<mid&&i2<e){
            if(sums[i1]<=sums[i2]){
                temp.push_back(sums[i1++]);
            }
            else{
                temp.push_back(sums[i2++]);
            }
        }
        while(i1<mid){
            temp.push_back(sums[i1++]);
        }
        while(i2<e){
            temp.push_back(sums[i2++]);
        }
        for(int idx=s;idx<e;idx++){
            sums[idx]=temp[idx-s];
        }
        return count;
    }
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int n=nums.size();
        vector<long long> sums(n+1,0);
        for(int i=1;i<=n;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        return mergeSort(0,n+1,sums,lower,upper);
    }
};