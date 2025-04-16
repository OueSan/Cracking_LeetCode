class StockSpanner {
  private static class Node {
      Node next;
      int height;
      int count;
      static Node LAST = new Node();
      static {
          LAST.height = 0x7FFF_FFFF;
          LAST.count = 0;
      }
  }
  private Node head = Node.LAST;
  private void insert(int height) {
      if (height == head.height)
      head.count += 1;
      else {
          Node n = new Node();
          n.height = height;
          n.count = 1;
          while (n.height >= head.height) {
              n.count += head.count;
              head = head.next;
          }
          n.next = head;
          head = n;
      }
  }
  public StockSpanner() {
  }
  public int next(int price) {
      insert(price);
      return head.count;
  }
}