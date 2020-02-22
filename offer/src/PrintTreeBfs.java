import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeBfs {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return result;
        }
        LinkedList<TreeNode> queue =new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int len = 1;
        while (queue.size() != 0){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
            len--;
            if (len == 0){
                result.add(list);
                list = new ArrayList<>();
                len = queue.size();
            }
        }
        return result;
    }
}
