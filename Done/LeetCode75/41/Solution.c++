class Solution {
  public:
      int maxLevelSum(TreeNode* root) {
          int ans = 0;
          int lvl = 1;
          int maxSum = INT_MIN;
          queue<TreeNode*> q;
          q.push(root);
          while(!q.empty()){
              int n = q.size();
              int sum = 0;
              for(int i = 0; i < n; i++){
                  TreeNode* ptr = q.front();
                  q.pop();
  
                  sum += ptr->val;
  
                  if(ptr->left) q.push(ptr->left);
                  if(ptr->right) q.push(ptr->right);
              };
              if(sum > maxSum) ans = lvl;
              maxSum = max(sum,maxSum);
              lvl++;
          };
          return ans ;
      }
  };