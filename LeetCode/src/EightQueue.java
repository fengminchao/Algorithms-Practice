/**
 * Created by ybao on 17/3/10.
 */
public class EightQueue {

    private static int max = 8;
    private static int array[]  = new int[max];
    private static int count = 0;

    public static void main(String[] args) {
        new EightQueue().check(0);
        System.out.println("count:" + count);
    }

    public void check(int n){
        if (n == max){
            print();
            return;
        }
        for (int i = 0;i < max;i ++){
            array[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    private void print() {
        for (int i = 0;i < max;i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        count ++;
    }

    public boolean judge(int n){
        for (int i = 0;i < n;i ++){
            if (Math.abs(n - i) == Math.abs(array[n] - array[i]) || array[n] == array[i]){
                return false;
            }
        }
        return true;
    }
}
