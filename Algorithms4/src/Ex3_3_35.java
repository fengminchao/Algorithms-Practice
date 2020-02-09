/**
 * Created by ybao on 17/3/31.
 * 红黑树实现
 */
public class Ex3_3_35 {

    static class Node<T> {
        static final boolean RED_NODE = true;
        static final boolean BLACK_NODE = false;

        boolean nodeColor;
        Comparable key;
        T value;

        int nodeNumber = 0;
        Node leftNode, rightNode;

        public Node(Comparable key, T value, int number, boolean color) {
            this.key = key;
            this.value = value;
            this.nodeNumber = number;
            this.nodeColor = color;
        }

        public boolean isRed() {
            return this.nodeColor == RED_NODE;
        }

        public int getSize() {
            return nodeNumber;
        }

        protected int size() {
            int nodeNumber = 1;
            if (leftNode != null) {
                nodeNumber += leftNode.getSize();
            }
            if (rightNode != null) {
                nodeNumber += rightNode.getSize();
            }
            return nodeNumber;
        }
    }

    public static class RedBlackTree<T> {
        private Node<T> root; // 根节点

        protected Node rotateLeft(Node node) {
            Node tmp = node.rightNode;
            node.rightNode = tmp.leftNode;
            tmp.leftNode = node;
            tmp.nodeColor = node.nodeColor;
            node.nodeColor = Node.RED_NODE;
            tmp.nodeNumber = node.nodeNumber;
            node.nodeNumber = node.size();
            return tmp;
        }

        protected Node rotateRight(Node node) {
            Node tmp = node.leftNode;
            node.leftNode = tmp.rightNode;
            tmp.rightNode = node;
            tmp.nodeColor = node.nodeColor;
            node.nodeColor = Node.RED_NODE;
            tmp.nodeNumber = node.nodeNumber;
            node.nodeNumber = node.size();
            return tmp;
        }

        protected Node rotateColor(Node node) {
            node.nodeColor = Node.RED_NODE;
            node.leftNode.nodeColor = Node.BLACK_NODE;
            node.rightNode.nodeColor = Node.BLACK_NODE;
            return node;
        }

        protected boolean isRed(Node node) {
            if (node == null) {
                return false;
            }
            return node.isRed();
        }

        public Node<T> search(Comparable key) {
            return search(key, this.root);
        }

        public Node<T> search(Comparable key, Node node) {
            if (node == null) {
                return null;
            }
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return search(key, node.leftNode);
            } else if (cmp > 0) {
                return search(key, node.rightNode);
            } else {
                return node;
            }
        }

        public void insert(Comparable key, T value) {
            Node<T> node = insertSubTree(this.root, key, value);
            node.nodeColor = Node.BLACK_NODE;
            this.root = node;
        }

        protected Node insertSubTree(Node node, Comparable key, T value) {
            if (node == null) {
                return new Node<T>(key, value, 1, Node.RED_NODE);
            }

            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.leftNode = insertSubTree(node.leftNode, key, value);
            } else if (cmp > 0) {
                node.rightNode = insertSubTree(node.rightNode, key, value);
            } else {
                node.value = value;
            }

            if (!isRed(node.leftNode) && isRed(node.rightNode)) {
                node = rotateLeft(node);
            }

            if (isRed(node.leftNode) && isRed(node.leftNode.leftNode)) {
                node = rotateRight(node);
            }

            if (isRed(node.leftNode) && isRed(node.rightNode)) {
                node = rotateColor(node);
            }
            node.nodeNumber = node.size();

            return node;
        }
    }


    public static void main(String[] args) {
        RedBlackTree<String> tree = new RedBlackTree<String>();

        int[] insertValue = new int[]{12, 1, 9, 10, 77, 2, 38, 8, 4};
        for (int value : insertValue) {
            tree.insert(value, "value_" + value);
        }

        Node node = tree.search(77);
        Node node1 = tree.search(12);
        System.out.println(node.value);
        System.out.println(node1.value);
        System.out.println("end");
    }
}
