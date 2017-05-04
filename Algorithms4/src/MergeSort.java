import java.util.Arrays;

/**
 * Created by ybao on 17/4/27.
 * 自顶向下归并排序
 */
public class MergeSort {

    public static int[] aux;

    public static void main(String[] args) {
        int[] n = {3, 2, 1, 6, 4, 9, 7};
        sort(n);
        System.out.println(Arrays.toString(n));
    }

    public static void sort(int[] n) {
        aux = new int[n.length];
        sort(n, 0, n.length - 1);
    }

    public static void sort(int[] n, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = (lo + hi) / 2;

        sort(n, lo, mid);
        sort(n, mid + 1, hi);
        merge(n, lo, mid, hi);
    }

    private static void merge(int[] n, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int m = lo; m <= hi; m++) {
            aux[m] = n[m];
        }

        for (int m = lo; m <= hi; m++) {
            if (i > mid) n[m] = aux[j++];
            else if (j > hi) n[m] = aux[i++];
            else if (n[i] < n[j]) n[m] = aux[i++];
            else n[m] = aux[j++];
        }
    }
}
