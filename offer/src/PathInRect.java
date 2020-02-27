import java.nio.file.Path;

/**
 *
 */
public class PathInRect {
    int strIndex = 0;
    int rows;
    int cols;

    public static void main(String[] args) {
        boolean r = new PathInRect().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),5,8,"SLHECCEIDEJFGGFIE".toCharArray());
        System.out.println(r);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < matrix.length; i++) {
            if (hasPath(matrix, str, i, strIndex)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, char[] str, int mIndex, int strIndex) {
        if (matrix[mIndex] == str[strIndex]) {
            char temp;
            temp = matrix[mIndex];
            matrix[mIndex] = '0';
            strIndex++;
            if (strIndex == str.length) {
                return true;
            }
            int top = mIndex - cols;
            if (top >= 0) {
                if (hasPath(matrix, str, top, strIndex)) {
                    return true;
                }
            }
            int bottom = mIndex + cols;
            if (bottom < matrix.length && hasPath(matrix, str, bottom, strIndex)) {
                return true;
            }
            int left = mIndex - 1;
            if (mIndex % cols != 0 && left >= 0 && hasPath(matrix, str, left, strIndex)) {
                return true;
            }
            int right = mIndex + 1;
            if (right % cols != 0 && hasPath(matrix, str, right, strIndex)) {
                return true;
            }
            strIndex--;
            matrix[mIndex] = temp;
        }
        return false;
    }

}
