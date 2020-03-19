import java.util.Arrays;

public class MinimumPathSum {

    private int[][] pathArr;
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        pathArr = new int[grid.length][grid[0].length];
        return minPath(grid,0,0);
    }

    public int minPath(int[][] grid,int row,int col){
        if (row == grid.length-1 && col == grid[0].length -1){
            return grid[row][col];
        }
        if (pathArr[row][col] != 0){
            return pathArr[row][col];
        }
        int colInc = Integer.MAX_VALUE;
        int rowInc = Integer.MAX_VALUE;
        if (row < grid.length - 1){
            rowInc = minPath(grid,row+1,col);
        }
        if (col < grid[0].length-1){
            colInc = minPath(grid,row,col+1);
        }
        pathArr[row][col] = Math.min(rowInc,colInc) + grid[row][col];
        return pathArr[row][col];
    }
}
