import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MedianInData {
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        if ((count & 1) == 0){
            if (maxHeap.size() != 0 && num < maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else {
                minHeap.offer(num);
            }
        }else {
            if (num > minHeap.peek()){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else {
                maxHeap.offer(num);
            }
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 1) == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else {
            return minHeap.peek().doubleValue();
        }
    }
}
