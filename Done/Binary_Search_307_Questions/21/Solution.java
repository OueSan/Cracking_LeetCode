class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] counter = new int[1001];
        for(int num : nums1)
        {
            counter[num] = 1;
        }
        int count=0;
        for(int num : nums2)
        {
            if(counter[num] == 1)
            {
                counter[num] = 2;
                count++;
            }
        }
        int[] res = new int[count];
        int ind=0;
        for(int i : nums2)
        {
            if(counter[i] == 2)
            {
                res[ind++] = i;
                counter[i] = 1;
            }
        }
        return res;
        
    }
}