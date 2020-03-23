import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] n = {-1, 2, 0, -1, 1, 0, 1};
        List<List<Integer>> r = new PermutationsII().permuteUnique(n);
        System.out.println(r);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        permuteUnique(nums, used, list, res);
        return res;
    }

    private void permuteUnique(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            permuteUnique(nums,used,list,res);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }

}
