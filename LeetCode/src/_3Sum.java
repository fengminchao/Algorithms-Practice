import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先排序，然后按序取一个数，夹逼法求另外两个数相加得之前数的负数
 */
public class _3Sum {

    public static void main(String[] args){
        int[] nums = {1,-1,-1,0};
        System.out.println(new _3Sum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return resultList;
        }
        Arrays.sort(nums);
        int lastNum = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length - 2;i++){
            if (lastNum == nums[i]){
                continue;
            }
            int sum = -1 * nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            int lastJNum = Integer.MAX_VALUE;
            int lastKNum = Integer.MIN_VALUE;
            while (j < k){
                if (lastJNum == nums[j]){
                    j++;
                    continue;
                }
                if (lastKNum == nums[k]){
                    k--;
                    continue;
                }
                int otherSum = nums[j] + nums[k];
                if (sum == otherSum){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    resultList.add(list);
                    lastJNum = nums[j];
                    lastKNum = nums[k];
                    j++;
                    k--;
                }else if (sum > otherSum){
                    lastJNum = nums[j];
                    j++;
                }else {
                    lastKNum = nums[k];
                    k--;
                }
            }
            lastNum = nums[i];
        }
        return resultList;
    }
}
