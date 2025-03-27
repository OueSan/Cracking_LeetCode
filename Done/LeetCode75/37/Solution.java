class Solution {
  int total = 0;
  public int pathSum(TreeNode root, int sum) {
      if(root == null) return 0;
      helper(root, sum, 0);
      pathSum(root.left, sum);
      pathSum(root.right, sum);
      return total;
  }

  void helper(TreeNode root, int sum, long curr) {
      if(root == null) return;
      curr += root.val;
      if(curr == sum) total++;
      helper(root.left, sum, curr);
      helper(root.right, sum, curr);
  }
}