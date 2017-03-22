/**
 * Created by ybao on 17/3/22.
 */
public class Ex300 {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = new Ex300().lengthOfLIS(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        int maxLength = calMaxLength(nums,new int[nums.length],0,0);
        return maxLength;
    }

    public int calMaxLength(int[] nums,int[] maxNums,int index,int maxLength){
        if (index > nums.length - 1){
            return maxLength;
        }

        for (int i = 0;i < index;i ++){
            if (nums[index] > nums[i]){
                maxNums[index] = Math.max(maxNums[i] + 1,maxNums[index]);
            }
        }
        if (maxNums[index] == 0){
            maxNums[index] = 1;
        }
        maxLength = Math.max(maxLength,maxNums[index]);
        return calMaxLength(nums,maxNums,++index,maxLength);
    }
}
