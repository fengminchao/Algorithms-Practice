import java.util.HashSet;

/**
 * Created by ybao on 17/4/11.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int result = new LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        final HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        int longest = 0;
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; set.contains(j); --j) {
                set.remove(j);
                ++length;
            }
            for (int j = i + 1; set.contains(j); ++j) {
                set.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

}
