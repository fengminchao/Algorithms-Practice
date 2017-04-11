/**
 * Created by ybao on 17/4/11.
 */
public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        boolean result = new ValidateBinarySearchTree().isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        return root.val > lower && root.val < upper
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
