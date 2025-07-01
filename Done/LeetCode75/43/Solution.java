class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) return null;
      if (root.val == key) return linker(root);
      TreeNode dummy = root;
      while (root != null) {
          if (root.val > key) {
              if (root.left != null && root.left.val == key) {
                  root.left = linker(root.left); break;
              }
              else root = root.left;
          }
          else{
              if (root.right != null && root.right.val == key) {
                  root.right = linker(root.right); break;
              }
              else root = root.right;
          }
      }
      return dummy;
  }
  public TreeNode linker(TreeNode root) {
      if (root.left == null) return root.right;
      if (root.right == null) return root.left;
      TreeNode rightChild = root.right;
      TreeNode extremeRight = f(root.left);
      extremeRight.right = rightChild;
      return root.left;
  }
  public TreeNode f(TreeNode root) {
      if (root.right == null) return root;
      return f(root.right);
  }
}