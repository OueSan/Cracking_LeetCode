class Solution {
public:
    int reachNumber(int target) {
        target=abs(target);
        int sum=0;
        int count=0;
        while(target>sum||(sum-target)%2!=0)
        {
            count++;
            sum+=count;
        }
        return count;
    }
};