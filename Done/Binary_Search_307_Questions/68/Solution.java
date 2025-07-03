class TopVotedCandidate {
int []nums;
int []tim;
    public TopVotedCandidate(int[] num, int[] times) {
        this.nums=new int[num.length];
        this.tim=times;
        Map<Integer,Integer>map=new HashMap<>();
        int temp=-1,max=-1;
        for(int i=0;i<nums.length;i++){
            int p=num[i];
            map.put(p,map.getOrDefault(p,0)+1);
            if(temp==-1||map.get(p)>=max){
                temp=p;
                max=map.get(p);
            }
            nums[i]=temp;
        }
    }
    
    public int q(int t) {
        return nums[bi(tim,t)];
    }
    public int bi(int arr[],int t){
        int i=0,j=arr.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]==t)return mid;
            else if(arr[mid]<t)i=mid+1;
            else j=mid-1;
        }
        return j;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */