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
      int check(TreeNode* root, bool f){
          if(f){
              if(root == NULL)return 0;
              return 1 + check(root->left,f);
          }else{
              if(root == NULL)return 0;
              return 1 + check(root->right,f);
          }
      }
      int countNodes(TreeNode* root) {
          int l = check(root,true);
          int r = check(root,false);
          if(l == r)return pow(2,l)-1;
          return 1 + countNodes(root->left) + countNodes(root->right);
      }
  };