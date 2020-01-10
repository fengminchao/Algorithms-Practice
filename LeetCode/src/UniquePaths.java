import java.util.Date;

/**
 * Created by ybao on 17/3/20.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()).getTime());
        int m = 23;
        int n = 11;
        System.out.println(new UniquePaths().uniquePaths(m, n));
        System.out.println(new Date(System.currentTimeMillis()).getTime());
    }

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
