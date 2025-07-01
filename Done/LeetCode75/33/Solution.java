/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int pairSum(ListNode head) {
      ListNode slow=head;
      ListNode fast=head;
      ListNode prev=null;
      while(fast!=null && fast.next!=null){//reversing half of the list
          fast=fast.next.next;
          ListNode next=slow.next;
          slow.next=prev;
          prev=slow;
          slow=next;
      }

      int max=0;
      while(slow!=null){//till slow reaches null
          int sum=slow.val+prev.val;
          max=Math.max(max,sum);
          slow=slow.next;//slow continues rightwards
          prev=prev.next;//prev goes left
      }
      return max;
  }
}