/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 斐波那契数列求和，其实是二的阶乘
 */
public class JumpFloorII {

    public static void main(String[] args) {
        int result = new JumpFloorII().JumpFloorII(3);
        System.out.println(result);
    }
    public int JumpFloorII(int target) {
        if (target == 0){
            return 0;
        }
        return 1 << (target - 1);
    }
}
