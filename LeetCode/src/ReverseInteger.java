import com.sun.tools.classfile.ConstantPool;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(120));
        System.out.println(reverseInteger.reverse(0));
        System.out.println(reverseInteger.reverse(0x80000000));
        System.out.println(reverseInteger.reverse(-1));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(-2147483412));
    }

    public int reverse(int x) {
        if (x == 0x80000000) {
            return 0;
        }
        int sign = x & 0x80000000;
        int num = sign != 0 ? -x : x;
        String maxStr = String.valueOf(0x7FFFFFFF);
        StringBuilder sb = new StringBuilder();
        boolean startWith0 = true;
        while (num > 0) {
            int curN = num % 10;
            if (curN == 0 && startWith0) {
            } else {
                startWith0 = false;
                sb.append(curN);
            }
            num /= 10;
        }
        String reverseStr = sb.toString();
        if (reverseStr.length() == 0) {
            return 0;
        }
        if (reverseStr.length() < maxStr.length()) {
            return Integer.parseInt(reverseStr) * (sign != 0 ? -1 : 1);
        }
        for (int i = 0; i < maxStr.length(); i++) {
            char reverseChar = reverseStr.charAt(i);
            char maxChar = maxStr.charAt(i);
            if (reverseChar > maxChar) {
                return 0;
            } else if (reverseChar == maxChar) {
                continue;
            } else {
                break;
            }
        }
        return Integer.parseInt(reverseStr) * (sign != 0 ? -1 : 1);
    }

    //this is better
    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
