class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> result=new ArrayList<>();
       for(int j=0;j<candies.length;j++)
       {
        if(candies[j]>max)
        {
            max=candies[j];
        }
       }
        for(int i=0;i<candies.length;i++)
        {
            
           if(candies[i]+extraCandies>=max)
            {
              
                result.add(true);
                // max=candies[i];
               
                
              
            }
         
            else
            {
                result.add(false);
                // max=candies[i];
             
            }
        }
        return result;
    }
}