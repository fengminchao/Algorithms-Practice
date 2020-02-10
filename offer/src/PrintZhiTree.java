import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintZhiTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean direction = false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(pRoot.val);
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(pRoot);
        while (true){
            ArrayList<Integer> list = new ArrayList<>();
            if (direction){
                for (int j = treeNodes.size() - 1;j >= 0;j--){
                    TreeNode node = treeNodes.remove(j);
                    if (node.left != null){
                        list.add(node.left.val);
                        treeNodes.add(node.left);
                    }
                    if (node.right != null){
                        list.add(node.right.val);
                        treeNodes.add(node.right);
                    }
                }
            }else {
                for (int j = treeNodes.size() - 1;j >= 0;j--){
                    TreeNode node = treeNodes.remove(j);
                    if (node.right != null){
                        list.add(node.right.val);
                        treeNodes.add(node.right);
                    }
                    if (node.left != null){
                        list.add(node.left.val);
                        treeNodes.add(node.left);
                    }
                }
            }
            if (list.size() == 0){
                break;
            }
            direction = !direction;
            result.add(list);
        }
        return result;
    }
}
