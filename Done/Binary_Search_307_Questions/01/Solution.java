class Solution {
  public double findMedianSortedArrays(int[] num1, int[] num2) {
     
      int[] num3 = new int[num1.length+num2.length];

      int i=0;
      int j=0;
      int k=0;

      while (k<num3.length) {
          if(i<num1.length && j<num2.length){
              if(num1[i]<num2[j]){
                  num3[k++] = num1[i++];
              }
              else{
                  num3[k++]=num2[j++];
              }
          }
          else if(j<num2.length){
              num3[k++] = num2[j++];
          }
          else if(i<num1.length){
              num3[k++] = num1[i++];
          }
      }
     
      
      double median = 0.0;
      if(num3.length%2==0)
        median=(num3[num3.length/2-1]+num3[num3.length/2])/2.0;
      else
      median=num3[num3.length/2];

      return median;
  }
}