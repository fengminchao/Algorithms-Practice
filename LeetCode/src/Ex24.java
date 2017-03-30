/**
 * Created by ybao on 17/3/30.
 */
public class Ex24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        while (head != null && head.next != null){
            ListNode t = head.next;
            head.next = head.next.next;
            t.next = head;
            pre.next = t;
            pre = head;
            head = head.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode node = headNode;
        for (int i = 2; i <= 6; i++) {
            ListNode listNode = new ListNode(i);
            node.next = listNode;
            node = listNode;
        }
        node = new Ex24().swapPairs(headNode);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
