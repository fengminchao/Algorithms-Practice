import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by ybao on 17/5/4.
 */
public class LRUCache {

    private int maxSize;
    private int size = 0;
    private HashMap<Integer, Node> map;
    private LinkedList<Node> linkedList;

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        int r1 = cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        int r2 = cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        int r3 = cache.get(1);       // returns -1 (not found)
        int r4 = cache.get(3);       // returns 3
        int r5 = cache.get(4);       // returns 4
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
    }

    public LRUCache(int capacity) {
        linkedList = new LinkedList<>();
        map = new HashMap<>();
        maxSize = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;
            linkedList.remove(node);
            linkedList.add(node);
            System.out.println(linkedList);
            return result;
        }
        System.out.println(linkedList);
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            Node node = map.get(key);
            linkedList.remove(node);
            linkedList.add(node);
        } else {
            if (size == maxSize) {
                Node node = linkedList.get(0);
                linkedList.remove(0);
                map.remove(node.key);
                Node newNode = new Node(key, value);
                linkedList.add(newNode);
                map.put(key, newNode);
            } else {
                Node node = new Node(key, value);
                linkedList.add(node);
                map.put(key, node);
                size++;
            }
        }
        System.out.println(linkedList);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
