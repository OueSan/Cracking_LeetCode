class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j] && !result.contains(nums1[i])){
                    result.add(nums1[i]);
                    continue;
                }
            }
        }
        int [] arr=new int[result.size()];
        int k=0;
        for(int num:result){
            arr[k]=num;
            k++;
        }
        return arr;
    }
}