import java.util.HashSet;
import java.util.Set;

/**
 * Created by ybao on 17/2/12.
 */
public class Ex73 {

    public static void main(String[] args) {
        Ex73 e = new Ex73();
        int[][] matrix = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        e.setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        boolean[] row = new boolean[colLength];
        boolean[] col = new boolean[rowLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }

        setRowZeroes(matrix,row);
        setColZeroes(matrix,col);

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void setRowZeroes(int[][] matrix, boolean[] row) {
        for (int j = 0;j < row.length;j ++) {
            if (row[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setColZeroes(int[][] matrix, boolean[] col) {
        for (int j = 0;j < col.length;j ++){
            if (col[j]){
                for (int i = 0;i < matrix[0].length;i ++){
                    matrix[j][i] = 0;
                }
            }
        }
    }

}
