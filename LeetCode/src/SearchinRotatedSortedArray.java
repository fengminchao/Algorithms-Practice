/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 找中点然后缩小一半搜索范围,这种方法耗时短但是空间占用大，LC 上有耗时稍长但空间占用小的解法是先找出旋转点，然后二分时找出真正的中点跟 target 比较
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args){
        int[] nums = {1,3};
        System.out.println(new SearchinRotatedSortedArray().search(nums,2));
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        return search(nums,0,nums.length - 1,target);
    }

    public int search(int[] nums,int startIndex,int endIndex,int target){
        if (startIndex == endIndex){
            return -1;
        }
        int centerIndex = (startIndex + endIndex) / 2;
        int start = nums[startIndex];
        int end = nums[endIndex];
        int center = nums[centerIndex];
        if (center == target){
            return centerIndex;
        }
        if (start == target){
            return startIndex;
        }
        if (end == target){
            return endIndex;
        }
        //center 有三种情况
        if (center >= start && center < end){
            if (target < center){
                return search(nums,startIndex,centerIndex,target);
            }else {
                return search(nums,centerIndex + 1,endIndex,target);
            }
        }else if (center >= start && start > end){
            if (target < center && target > start){
                return search(nums,startIndex,centerIndex,target);
            }else {
                return search(nums,centerIndex + 1,endIndex,target);
            }
        }else {
            if (target > center && target < end){
                return search(nums,centerIndex + 1,endIndex,target);
            }else {
                return search(nums,startIndex,centerIndex,target);
            }
        }
    }
}
