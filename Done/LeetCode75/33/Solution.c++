/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
  public:
      // Function to reverse a linked list
      ListNode* reverseList(ListNode* head) {
          ListNode* prev = nullptr;
          ListNode* curr = head;
          while (curr) {
              ListNode* nextTemp = curr->next;
              curr->next = prev;
              prev = curr;
              curr = nextTemp;
          }
          return prev;
      }
      int pairSum(ListNode* head) {
          if (!head)
              return 0;
  
          // Step 1: Find the middle using slow & fast pointers
          ListNode *slow = head, *fast = head;
          while (fast && fast->next) {
              slow = slow->next;
              fast = fast->next->next;
          }
  
          // Step 2: Reverse the second half of the linked list
          ListNode* secondHalf = reverseList(slow);
          ListNode* firstHalf = head;
  
          // Step 3: Calculate the maximum twin sum
          int maxTwinSum = 0;
          while (secondHalf) {
              maxTwinSum = max(maxTwinSum, firstHalf->val + secondHalf->val);
              firstHalf = firstHalf->next;
              secondHalf = secondHalf->next;
          }
  
          return maxTwinSum;
      }
  };