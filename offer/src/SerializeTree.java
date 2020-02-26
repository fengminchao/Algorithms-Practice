import java.util.LinkedList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class SerializeTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Serialize2(root,sb);
        return sb.toString();
    }

    void Serialize2(TreeNode node,StringBuilder sb){
        if (node == null){
            sb.append("#,");
            return;
        }
        sb.append(node.val + ",");
        Serialize2(node.left,sb);
        Serialize2(node.right,sb);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        String[] arr = str.split(",");
        TreeNode node = Deserialize2(arr);
        return node;
    }

    TreeNode Deserialize2(String[] arr){
        index++;
        if (!"#".equals(arr[index])){
            TreeNode node = new TreeNode(Integer.valueOf(arr[index]));
            node.left = Deserialize2(arr);
            node.right = Deserialize2(arr);
            return node;
        }
        return null;
    }

}
