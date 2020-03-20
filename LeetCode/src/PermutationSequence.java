import java.util.LinkedList;
import java.util.List;

/**
 * Created by ybao on 17/4/2.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 4;
        int k = 6;
        String s = new PermutationSequence().getPermutation(n, k);
        System.out.println(s);
    }

    public String getPermutation(int n, int k) {
        int i = n - 1;
        int product = 1;
        while (i > 0) {
            product *= i;
            i--;
        }

        int[] nums = new int[n];

        i = n - 1;
        k = k - 1;
        while (k != 0) {
            nums[i] = k / product;
            k = k % product;
            product /= i;
            i--;
        }
        nums[i] = k;
        List<Integer> list = new LinkedList();
        for (int j = 1; j <= n; j++) {
            list.add(j);
        }
        StringBuilder sb = new StringBuilder("");
        for (int j = n - 1; j >= 0; j--) {
            sb.append(list.remove(nums[j]));
        }
        return sb.toString();
    }
}
