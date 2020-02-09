public class RebuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = new RebuildTree().reConstructBinaryTree(pre,in);
        printTree(node);
    }

    static void printTree(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val + ",");
        printTree(node.left);
        printTree(node.right);
    }

    int preIndex = 0;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return createNode(pre,in,0,pre.length - 1);
    }

    private TreeNode createNode(int[] pre, int[] in, int start, int end){
        if (start > end || preIndex >= pre.length){
            return null;
        }
        int faIndex = -1;
        for (int j = start;j <= end;j++){
            if (in[j] == pre[preIndex]){
                faIndex = j;
                break;
            }
        }
        TreeNode faNode = new TreeNode(pre[preIndex]);
        preIndex++;
        faNode.left = createNode(pre,in, start,faIndex - 1);
        faNode.right = createNode(pre,in,faIndex + 1,end);
        return faNode;
    }

}
