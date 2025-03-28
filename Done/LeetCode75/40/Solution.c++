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
  
  void find(TreeNode*root,int lvl,int curr,vector<int>&v){
      if(root==NULL) return ;
  
      if(lvl==curr){
          v[lvl]=root->val;
      }
      find(root->left,lvl,curr+1,v);
      find(root->right,lvl,curr+1,v);
  }
  
  
  int level(TreeNode*root){
      if(root==NULL) return 0;
      return 1+max(level(root->left),level(root->right));
  }
      vector<int> rightSideView(TreeNode* root) {
  int n=level(root);
  vector<int>v(n);
  for(int i=0; i<n; i++){
      find(root,i,0,v);
  }
  
  return v;
  
      }
  };