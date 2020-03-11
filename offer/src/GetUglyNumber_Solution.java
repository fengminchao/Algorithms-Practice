//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
// 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        int[] arr = new int[index];
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        arr[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            int n2 = arr[t2] * 2;
            int n3 = arr[t3] * 3;
            int n5 = arr[t5] * 5;
            while (n2 <= arr[i - 1]) {
                n2 = arr[++t2] * 2;
            }
            while (n3 <= arr[i - 1]) {
                n3 = arr[++t3] * 3;
            }
            while (n5 <= arr[i - 1]) {
                n5 = arr[++t5] * 5;
            }
            if (n2 <= n3 && n2 <= n5) {
                arr[i] = n2;
                t2++;
            } else if (n3 <= n5 && n3 <= n2) {
                arr[i] = n3;
                t3++;
            } else {
                arr[i] = n5;
                t5++;
            }
        }
        return arr[index - 1];
    }
}
