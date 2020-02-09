/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 其实他就是个斐波那契数列，第 n 级台阶是跳一级然后在f(n-1)种跳法，加上跳两级然后f(n-2)种跳法
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        int sum = 1;
        int last = 1;
        for (int i = 2;i <= target;i++){
            sum = sum + last;
            last = sum - last;
        }
        return sum;
    }
}
