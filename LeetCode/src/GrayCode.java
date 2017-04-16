import java.util.LinkedList;
import java.util.List;

/**
 * Created by ybao on 17/4/16.
 */
public class GrayCode {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new GrayCode().grayCode(n));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
