class Solution {
    public int reversePairs(int[] nums) {
          return mergeSort(nums,0,nums.length-1);
    }
    int mergeSort(int[] nums,int low,int high){
          if(low >= high) return 0;
          int mid = low+(high-low)/2;
          int cnt = mergeSort(nums,low,mid)+mergeSort(nums,mid+1,high);
          int j = mid+1;
          for(int i = low;i <= mid;i++){
              while(j <= high && nums[i] > 2L*nums[j])
                 j++;
              cnt += j-(mid+1);
          }
          merge(nums,low,mid,high);
          return cnt;
    }
    void merge(int[] nums,int low,int mid,int high){
          int[] temp = new int[high-low+1];
          int i = low,j = mid+1,k = 0;
          while(i <= mid && j <= high){
               if(nums[i]>nums[j])
                  temp[k++] = nums[j++];
               else
                  temp[k++] = nums[i++];
          }
          while(i <= mid){
              temp[k++] = nums[i++];
          }
          while(j <= high){
              temp[k++] = nums[j++];
          }
          System.arraycopy(temp,0,nums,low,temp.length);
    }
}