/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {

    public static void main(String[] args){
        int[] arr = {1};
        int result = new FirstMissingPositive().firstMissingPositive(arr);
        System.out.println(result);
    }


    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i = 0;i<nums.length;i++){
            if (nums[i] < arr.length && nums[i] > 0){
                arr[nums[i]]++;
            }
        }
        for (int i = 1;i < arr.length;i++){
            if (arr[i] == 0){
                return i;
            }
        }
        return arr.length;
    }
}
