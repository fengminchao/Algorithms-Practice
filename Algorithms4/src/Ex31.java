import java.util.Arrays;

/**
 * Created by ybao on 17/4/2.
 */
public class Ex31 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1};
        new Ex31().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            print(nums);
            return;
        }

        boolean b = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = findTarget(nums, i);
                swap(nums, i, j);
                reverse(nums, i + 1);
                print(nums);
                b = false;
                break;
            }
        }
        if (b) {
            reverse(nums, 0);
            print(nums);
        }
    }

    private void reverse(int[] nums, int i) {
        for (int j = i; j < (nums.length + i) / 2; j++) {
            int t = nums[j];
            nums[j] = nums[nums.length - 1 - j + i];
            nums[nums.length - 1 - j + i] = t;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (j < nums.length) {
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
    }

    public int findTarget(int[] nums, int i) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] <= nums[i]) {
                return j - 1;
            }
        }
        return nums.length - 1;
    }

    public void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }


}
