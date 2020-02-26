public class MinKNodeInTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private int k = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        this.k = k;
        return traverseTree(pRoot);
    }

    private TreeNode traverseTree(TreeNode pRoot) {
        if (pRoot == null){
            return null;
        }
        TreeNode left = traverseTree(pRoot.left);
        if (left != null){
            return left;
        }
        k -= 1;
        if (k == 0){
            return pRoot;
        }
        TreeNode right = traverseTree(pRoot.right);
        if (right != null){
            return right;
        }
        return null;
    }
}
