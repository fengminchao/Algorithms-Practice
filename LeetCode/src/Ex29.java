import java.util.Scanner;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Created by ybao on 17/1/18.
 */
public class Ex29 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dividend = s.nextInt();
        int divisor = s.nextInt();
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;

        while (a >= b) {
            long c = b;
            int i = 0;
            while (c <= a) {
                a = a - c;
                c = c << 1;
                result += 1 << i;
                i++;
            }

        }

        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
