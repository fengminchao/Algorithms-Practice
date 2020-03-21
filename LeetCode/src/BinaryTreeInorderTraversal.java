import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if (root == null){
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
