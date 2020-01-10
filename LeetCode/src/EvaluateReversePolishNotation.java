import java.util.Stack;

/**
 * Created by ybao on 17/3/23.
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] arr =  {"4", "13", "5", "/", "+"};
        int result = new EvaluateReversePolishNotation().evalRPN(arr);
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++){
            int num = 0;
            switch (tokens[i]){
                case "+":
                    num = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num));
                    break;
                case "-":
                    num = -1 * Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num));
                    break;
                case "*":
                    num = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num));
                    break;
                case "/":
                    num = Integer.parseInt(stack.pop());
                    num = Integer.parseInt(stack.pop()) / num;
                    stack.push(String.valueOf(num));
                    break;
                default:
                    stack.push(tokens[i]);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
