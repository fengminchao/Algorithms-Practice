public class IsBalanced_Solution {
    static class TreeNode{
        public TreeNode left;
        public TreeNode right;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = depth(node.left);
        if (left == -1){
            return -1;
        }
        int right = depth(node.right);
        if (right == -1){
            return -1;
        }
        if (left - right < -1 || left - right > 1){
            return -1;
        }else {
            return 1 + (left > right ? left : right);
        }
    }
}
