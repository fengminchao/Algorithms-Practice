import java.util.Date;

/**
 * Created by ybao on 17/3/20.
 * 使用动态规划实现 f[i][j] = f[i-1][j]+f[i][j-1]
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
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 0;i<m;i++){
            for (int j = 1;j<n;j++){
                f[j]=f[j]+f[j-1];
            }
        }
        return f[n-1];
    }
}
