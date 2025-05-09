public class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> leafValues1 = new ArrayList<>();
      List<Integer> leafValues2 = new ArrayList<>();
      
      collectLeafValues(root1, leafValues1);
      collectLeafValues(root2, leafValues2);

      return leafValues1.equals(leafValues2);
  }

  private void collectLeafValues(TreeNode root, List<Integer> leafValues) {
      if (root == null) {
          return;
      }
      if (root.left == null && root.right == null) {
          leafValues.add(root.val);
      }
      collectLeafValues(root.left, leafValues);
      collectLeafValues(root.right, leafValues);
  }
}