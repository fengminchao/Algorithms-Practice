
/**
 * Created by ybao on 16/12/29.
 */
public class Ex1_1_20 {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        StdOut.print(ln(N));
    }

    public static double ln(int N) {
        if (N == 1) return 0;
        return (ln(N - 1) + Math.log(N));

    }
}