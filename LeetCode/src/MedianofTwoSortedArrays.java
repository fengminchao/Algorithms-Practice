/**
 * Created by ybao on 17/4/2.
 */
public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {2, 4};
        int[] b = {1, 3, 5};
        double d = new MedianofTwoSortedArrays().findMedianSortedArrays(a, b);
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int total = A.length + B.length;
        if (total % 2 == 1) {
            return findKPosition(A, 0, B, 0, total / 2 + 1);
        } else {
            return findKPosition(A, 0, B, 0, total / 2) +
                    findKPosition(A, 0, B, 0, total / 2 + 1) / 2.0;
        }
    }

    private int findKPosition(final int[] A, int ai, final int[] B, int bi, int k) {
        if (A.length - ai > B.length - bi) {
            return findKPosition(B, bi, A, ai, k);
        }
        if (A.length - ai == 0) {
            return B[bi + k - 1];
        }
        if (k == 1) {
            return Math.min(A[ai], B[bi]);
        }

        int k1 = Math.min(k / 2, A.length - ai), k2 = k - k1;
        if (A[ai + k1 - 1] < B[bi + k2 - 1]) {
            return findKPosition(A, ai + k1, B, bi, k - k1);
        } else if (A[ai + k1 - 1] > B[bi + k2 - 1]) {
            return findKPosition(A, ai, B, bi + k2, k - k2);
        } else {
            return A[k1 - 1];
        }

    }
}
