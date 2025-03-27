/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
  public:
      int pathSum(TreeNode* root, int targetSum) {
          unordered_map<long long, int> prefixSumCount; // Use long long for prefix sums
          prefixSumCount[0] = 1; // Initialize with {0: 1}
          return dfs(root, 0, targetSum, prefixSumCount);
      }
  
  private:
      int dfs(TreeNode* node, long long currentSum, int targetSum, unordered_map<long long, int>& prefixSumCount) {
          if (node == nullptr) {
              return 0; // Base case: no nodes to process
          }
  
          // Update the current cumulative sum
          currentSum += node->val;
  
          // Check if (currentSum - targetSum) exists in the prefix sum map
          int numPaths = prefixSumCount[currentSum - targetSum];
  
          // Update the prefix sum map with the current cumulative sum
          prefixSumCount[currentSum]++;
  
          // Recursively traverse the left and right subtrees
          numPaths += dfs(node->left, currentSum, targetSum, prefixSumCount);
          numPaths += dfs(node->right, currentSum, targetSum, prefixSumCount);
  
          // Backtrack: decrement the frequency of the current cumulative sum
          prefixSumCount[currentSum]--;
  
          return numPaths;
      }
  };