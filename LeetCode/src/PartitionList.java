public class PartitionList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode partition(ListNode head, int x) {
          ListNode lessHead = new ListNode(-1);
          ListNode greatHead = new ListNode(-1);
          greatHead.next = head;
          ListNode last = greatHead;
          ListNode lessNode = lessHead;
          while (head != null){
              if (head.val < x){
                  lessNode.next = head;
                  lessNode = head;
                  last.next = head.next;
              }else {
                  last = head;
              }
              head = head.next;
          }
          lessNode.next = greatHead.next;
          return lessHead.next;
    }
}
