//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class Merge {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node = new Merge().Merge(node1,node3);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null){
            node.next = list1;
        }
        if (list2 != null){
            node.next = list2;
        }
        return head.next;
    }
}

