import java.util.Scanner;

/**
 * Created by ybao on 16/12/29.
 */
public class Ex1_1_22 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int location = rank(3, array);
        if (location < 0)
            StdOut.print("no found");
        else
            StdOut.print("location: " + location);

    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int dep) {
        int mid = lo + (hi - lo) / 2;
        for (int i = 0; i < dep; i++)
            StdOut.print(" ");
        StdOut.println("low:" + lo + " height:" + hi);
        if (lo == hi){
            return -1;
        }
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return rank(key, a, lo, mid, ++dep);
        } else {
            return rank(key, a, mid, hi, ++dep);
        }
    }
}
