import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        findPath(list, root, target);
        Collections.sort(totalList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return totalList;
    }

    private void findPath(ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && target == root.val) {
            ArrayList<Integer> endList = new ArrayList(list);
            endList.add(target);
            totalList.add(endList);
            return;
        }
        if (root.val <= target) {
            list.add(root.val);
            int index = list.size() - 1;
            target -= root.val;
            findPath(list, root.left, target);
            findPath(list, root.right, target);
            list.remove(index);
        }
    }
}
