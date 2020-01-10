/**
 * Created by ybao on 17/3/20.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        boolean b = new JumpGame().canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        int reach = 1;
        for (int i = 0; i < reach && reach < nums.length; i++) {
            reach = Math.max(reach, i + 1 + nums[i]);
        }
        return reach >= nums.length;
    }
}
