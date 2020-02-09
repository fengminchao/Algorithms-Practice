import java.util.*;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class ReverseList {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //{1,1,2,3,3,4,5,5}
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        ListNode head = new ReverseList().deleteDuplication(n1);
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new ArrayList<String>();
        list2.add("0");
        list2.add("1");
        list2.add("2");
        List<List<String>> dimValue = new ArrayList<List<String>>();
        dimValue.add(list1);
        dimValue.add(list2);

        // 递归实现笛卡尔积
        List<List<String>> res = new ReverseList().descarte2(dimValue);
        System.out.println("递归实现笛卡尔乘积: 共 " + res.size() + " 个结果");
        for (List<String> list : res) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
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

    public List<List<String>> descartes(List<List<String>> dimValue) {
        List<List<String>> res = new ArrayList<>();
        if (dimValue == null || dimValue.size() == 0)
            return res;
        backtrace(dimValue, 0, res, new ArrayList<>());
        return res;
    }

    public List<List<String>> descarte2(List<List<String>> dimValue){
        List<List<String>> result = new ArrayList<>();
        if (dimValue == null || dimValue.size() == 0){
            return result;
        }
        descarteRecursive(dimValue,result,0,new ArrayList<String>());
        return result;
    }

    private void descarteRecursive(List<List<String>> dimValue, List<List<String>> result, int layer,List<String> curList) {
        if (layer == dimValue.size()){
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0;i < dimValue.get(layer).size();i++){
            curList.add(dimValue.get(layer).get(i));
            descarteRecursive(dimValue,result,layer+1,curList);
            curList.remove(dimValue.get(layer).get(i));
        }
    }

    /**
     * 递归回溯法求解
     *
     * @param dimValue 原始数据集合
     * @param index    当前执行的集合索引
     * @param result   结果集合
     * @param curList  当前的单个结果集
     */
    private void backtrace(List<List<String>> dimValue, int index,
                           List<List<String>> result, List<String> curList) {
        if (curList.size() == dimValue.size())
            result.add(new ArrayList<>(curList));
        else
            for (int j = 0; j < dimValue.get(index).size(); j++) {
                curList.add(dimValue.get(index).get(j));
                backtrace(dimValue, index + 1, result, curList);
                curList.remove(curList.size() - 1);
            }
    }

    private static void circulate(List<List<String>> dimValue, List<List<String>> result) {
        int total = 1;
        for (List<String> list : dimValue) {
            total *= list.size();
        }
        String[] myResult = new String[total];
        int itemLoopNum = 1;
        int loopPerItem = 1;
        int now = 1;
        for (List<String> list : dimValue) {
            now *= list.size();
            int index = 0;
            int currentSize = list.size();
            itemLoopNum = total / now;
            loopPerItem = total / (itemLoopNum * currentSize);
            int myIndex = 0;
            for (String string : list) {
                for (int i = 0; i < loopPerItem; i++) {
                    if (myIndex == list.size()) {
                        myIndex = 0;
                    }
                    for (int j = 0; j < itemLoopNum; j++) {
                        myResult[index] = (myResult[index] == null ? "" : myResult[index] + ",") + list.get(myIndex);
                        index++;
                    }
                    myIndex++;
                }
            }
        }
        List<String> stringResult = Arrays.asList(myResult);
        for (String string : stringResult) {
            String[] stringArray = string.split(",");
            result.add(Arrays.asList(stringArray));
        }
    }
}

