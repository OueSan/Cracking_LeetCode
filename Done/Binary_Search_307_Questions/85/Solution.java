class Solution {
    public int findBestValue(int[] arr, int target) {
        int l, r, mi, s=0, m=-1;
        for(int v:arr) { s += v; m=Math.max(m,v); }

        if(s<=target) return m; // return the max value since we will keep all nums as is

        for(l=1,r=m;l<r;) {
            mi=(l+r)/2;
            s=0;
            for(int v:arr) s += (v>mi)?mi:v;
            if(s>=target) r=mi;
            else          l=mi+1;
        }
        // check if we are 1 step off the target 
        int s1=0,s2=0;
        for(int v:arr) {
            s1 += (v>l)?(l):v;
            s2 += (v>l-1)?(l-1):v;
        }
        
        return (Math.abs(s2-target) <= Math.abs(s1-target)) ? l-1 : l;
    }
}