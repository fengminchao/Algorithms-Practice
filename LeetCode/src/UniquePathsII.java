/**
 * 动态规划实现
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m[1][1] = 1;
        int r = new UniquePathsII().uniquePathsWithObstacles(m);
        System.out.println(r);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] path = new int[n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        path[0] = 1;
        for (int i = 0; i < m; i++) {
            path[0] = path[0] == 0 ? 0 : obstacleGrid[i][0] == 1 ? 0 : 1;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[j] = 0;
                } else {
                    path[j] = path[j] + path[j - 1];
                }
            }
        }
        return path[n - 1];
    }

    int[][] f;
    int m, n;

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        f = new int[m][n];
        f[0][0]=1;
        dfs(obstacleGrid,m-1,n-1);
        return f[m-1][n-1];
    }

    private int dfs(int[][] obstacleGrid, int x, int y) {
        if (x < 0 || y <0){
            return 0;
        }
        if (obstacleGrid[x][y] == 1){
            return 0;
        }
        if (x == 0 && y == 0){
            return f[0][0];
        }
        if (f[x][y] > 0){
            return f[x][y];
        }else {
            f[x][y] = dfs(obstacleGrid, x - 1, y) + dfs(obstacleGrid, x, y - 1);
            return f[x][y];
        }
    }
}
