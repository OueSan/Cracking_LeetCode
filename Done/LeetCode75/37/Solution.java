class Solution {
  int count = 0;
  int k;
  HashMap<Long, Integer> h = new HashMap();
  
  public void preorder(TreeNode node, long currSum) {
      if (node == null)
          return;
      
      // The current prefix sum
      currSum += node.val;

      // Here is the sum we're looking for
      if (currSum == k)
          count++;
      
      // The number of times the curr_sum − k has occurred already, 
      // determines the number of times a path with sum k 
      // has occurred up to the current node
      count += h.getOrDefault(currSum - k, 0);
      
      //Add the current sum into the hashmap
      // to use it during the child node's processing
      h.put(currSum, h.getOrDefault(currSum, 0) + 1);

      // Process the left subtree
      preorder(node.left, currSum);

      // Process the right subtree
      preorder(node.right, currSum);

      // Remove the current sum from the hashmap
      // in order not to use it during 
      // the parallel subtree processing
      h.put(currSum, h.get(currSum) - 1);
  }    
          
  public int pathSum(TreeNode root, int sum) {
      k = sum;
      preorder(root, 0L);
      return count;
  }
}