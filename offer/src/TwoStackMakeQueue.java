import java.util.Stack;

public class TwoStackMakeQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        stack2.push(node);
    }

    public int pop() {
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
}
