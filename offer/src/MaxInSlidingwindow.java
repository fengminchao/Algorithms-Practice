import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInSlidingwindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size > num.length || size <= 0){
            return list;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int begin = -1 * size;
        for (int i = 0;i < num.length;i++){
            begin++;
            if (deque.isEmpty()){
                deque.add(i);
            }else if (begin > deque.peekFirst()){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]){
                deque.pollLast();
            }
            deque.add(i);
            if (begin>=0) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }
}
