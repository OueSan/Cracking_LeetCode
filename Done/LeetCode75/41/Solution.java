class Solution {
  private int totalLvl;
  private int sumAtLvl[]=new int [1000];
  public int maxLevelSum(TreeNode root) {
      int res=1, max=Integer.MIN_VALUE;

      helper(root,0);

      for(int i=0;i<=totalLvl;i++)
      {
          int sum=sumAtLvl[i];

          if(sum>max){
              max=sum;
              res=i+1;
          }
      }
      return res;
  }

  private void helper(TreeNode node,int l)
  {
      if(node==null)return;

      sumAtLvl[l]+=node.val;

      totalLvl=Math.max(totalLvl,l);

      helper(node.right,l+1);
      helper(node.left,l+1);
  }
}