import java.util.Stack;
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该
// 压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class IsPopOrder {

    public static void main(String[] args) {

    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int m = 0; m < len; m++) {
            if (stack.size() != 0 && stack.peek() == popA[m]){
                stack.pop();
                continue;
            }
            boolean r = false;
            for (int i = index;i < len;i++){
                if (pushA[i] == popA[m]){
                    r = true;
                    index = i + 1;
                    break;
                }
                stack.push(pushA[i]);
            }
            if (!r){
                return false;
            }
        }
        return true;
    }
}
