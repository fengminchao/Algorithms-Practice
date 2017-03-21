import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ybao on 17/3/21.
 */
public class Ex34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] index = new Ex34().searchRange(nums, target);
        String s = Arrays.toString(index);
        System.out.println(s);
    }

    public int[] searchRange(int[] nums, int target) {
        int low = low(nums,0,nums.length,target);
        int high = high(nums,0,nums.length,target);

        if (low >= nums.length || nums[low] != target){
            return new int[]{-1,-1};
        }else {
            return new int[]{low,high - 1};
        }
    }


    public int low(int[] nums,int start,int end,int target){
        while (start != end){
            int mid = (end - start) / 2 + start;
            if (target > nums[mid]){
                start = ++mid;
            }else {
                end = mid;
            }
        }
        return start;
    }

    public int high(int[] nums,int start,int end,int target){
        while (start != end){
            int mid = (end - start) / 2 + start;
            if (target >= nums[mid] ){
                start = ++mid;
            }else {
                end = mid;
            }
        }
        return start;
    }
}
