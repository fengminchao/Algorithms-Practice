import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] n = {1, 2, 3};
        List<List<Integer>> list = new Permutations().permute(n);
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length - 1);
        return res;
    }

    private void permute(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end){
            List<Integer> list = new ArrayList<>();
            for (int n:nums){
                list.add(n);
            }
            res.add(list);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
