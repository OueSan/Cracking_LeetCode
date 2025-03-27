class Solution {
  public int pairSum(ListNode head) {
      ArrayList<Integer> ll = new ArrayList<>();
      ListNode temp = head;
      while(temp!=null){
          ll.add(temp.val);
          temp = temp.next;
      }
      int n = ll.size(),maxx=-1;
      for(int i=0;i<n/2;i++){
          int x = ll.get(i)+ll.get(n-i-1);
          maxx = Math.max(maxx,x);
      }
      return maxx;
  }
}