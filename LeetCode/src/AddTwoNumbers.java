/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode node = new AddTwoNumbers().addTwoNumbers(l1,l4);
        while (node != null){
            System.out.print(node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = l1;
        int carryNum = 0;
        while (l1 != null){
            if (l2 != null){
                l1.val = l1.val + l2.val + carryNum;
                if (l1.next == null && l2.next != null){
                    l1.next = new ListNode(0);
                }
            }else {
                l1.val += carryNum;
            }
            carryNum = l1.val / 10;
            l1.val = l1.val % 10;
            if (carryNum != 0 && l1.next == null) {
                l1.next = new ListNode(0);
            }
            l1 = l1.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return resultNode;
    }
}
