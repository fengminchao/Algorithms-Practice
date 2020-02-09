import java.util.ArrayList;

public class PrintLinkReverse {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        addList(listNode);
        return list;
    }

    private void addList(ListNode listNode) {
        if (listNode == null){
            return;
        }
        addList(listNode.next);
        list.add(listNode.val);
    }
}
