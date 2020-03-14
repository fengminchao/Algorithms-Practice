public class deleteDuplication {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(Integer.MAX_VALUE);
        first.next = pHead;
        ListNode node = pHead;
        ListNode last = first;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                int val = node.val;
                while (node != null && node.val == val) {
                    node = node.next;
                }
                last.next = node;
            } else {
                last = node;
                node = node.next;
            }
        }
        return first.next;
    }
}

