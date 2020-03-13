//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//异或解决
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int result = 0;
        for (int i : array) {
            result = result ^ i;
        }
        int n = 1;
        while (result != 0) {
            if ((result & n) != 0) {
                break;
            } else {
                n = n << 1;
            }
        }
        int result1 = 0,result2 = 0;
        for (int i : array) {
            if ((n & i) != 0) {
                result1 = result1 ^ i;
            }else {
                result2 = result2 ^ i;
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
