import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

/**
 * 二叉查找树通过先序遍历是一组有序的数列，第一个错误节点大于之后的数，第二个错误节点小于之前的数
 */
public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node.left = node1;
        node1.right = node2;
        new RecoverBinarySearchTree().recoverTree(node);
    }

    private TreeNode firstNode;
    private TreeNode secondNode;
    private TreeNode preNode;

    public void recoverTree(TreeNode root) {
        preNode = new TreeNode(Integer.MIN_VALUE);
        findWrongNode(root);
        TreeNode temp = new TreeNode(Integer.MIN_VALUE);
        temp.val = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp.val;
    }

    private void findWrongNode(TreeNode root) {
        if (root == null){
            return;
        }
        findWrongNode(root.left);
        if (firstNode == null && preNode.val > root.val){
            firstNode = preNode;
        }
        if (firstNode != null && root.val < preNode.val){
            secondNode = root;
        }
        preNode = root;
        findWrongNode(root.right);
    }

}
