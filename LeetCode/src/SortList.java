/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node = new SortList().sortList(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode midAfter = mid.next;
        mid.next = null;
        head = sortList(head);
        midAfter = sortList(midAfter);
        return mergeList(head, midAfter);
    }

    private ListNode mergeList(ListNode head, ListNode midAfter) {
        ListNode start = new ListNode(0);
        ListNode index = start;
        while (head != null || midAfter != null) {
            int val1 = head == null ? Integer.MAX_VALUE : head.val;
            int val2 = midAfter == null ? Integer.MAX_VALUE : midAfter.val;
            if (val1 <= val2){
                index.next = head;
                head = head.next;
                index = index.next;
            }else {
                index.next = midAfter;
                midAfter = midAfter.next;
                index = index.next;
            }
        }
        return start.next;
    }

    private ListNode findMidNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        while (node2 != null) {
            if (node2.next != null) {
                node2 = node2.next.next;
            } else {
                break;
            }
            node1 = node1.next;
        }
        return node1;
    }
}
