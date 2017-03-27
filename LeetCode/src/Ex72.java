/**
 * Created by ybao on 17/3/27.
 */
public class Ex72 {
    public static void main(String[] args) {
        String w1 = "home";
        String w2 = "school";
        int result = new Ex72().minDistance(w1,w2);
        System.out.println(result);
    }

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            f[i][0] = i;
        for (int j = 0; j <= m; j++)
            f[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1];
                else {
                    int mn = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = 1 + Math.min(f[i - 1][j - 1], mn);
                }
            }
        }
        return f[n][m];
    }
}
