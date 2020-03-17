import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] a = {2,-1,2,-1,2,-2,2};
        int r = new MaximumProductSubarray().maxProduct(a);
        System.out.println(r);
    }
    int maxProduct(int nums[]) {
        int r = nums[0];

        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            if (nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = max(nums[i], imax * nums[i]);
            imin = min(nums[i], imin * nums[i]);

            r = max(r, imax);
        }
        return r;
    }

}
