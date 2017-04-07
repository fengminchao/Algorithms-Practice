import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by ybao on 17/4/2.
 */
public class Ex60 {

    public static void main(String[] args) {
        int n = 5;
        int k = 29;
        String s = new Ex60().getPermutation(n,k);
        System.out.println(s);
    }

    public String getPermutation(int n, int k) {
        int i = n - 1;
        int product = 1;
        while (i > 0) {
            product *= i;
            i--;
        }

        int[] nums = new int[9];

        i = n - 1;
        for (; i > 1; i--) {
            if (k / product > 0) {
//                nums[i] = k / product + 1;
                nums[i] = (k + 1) / product;
                k = k % product;
                product /= i;
            }
        }
        List<Integer> list = new LinkedList();
        for (int j = 1; j <= n; j++) {
            list.add(j);
        }
        StringBuilder sb = new StringBuilder("");
        for (int j = n - 1;j >= 0;j--){
            System.out.println("nums" + nums[j]);
            if (nums[j] != 0){
                sb.append(list.remove(nums[j]));
            }else {
                sb.append(list.remove(0));
            }
        }
        return sb.toString();
    }
}
