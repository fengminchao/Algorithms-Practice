public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int lastN1 = 0;
        int lastN2 = 1;
        int result = 0;
        for (int i = 2;i <= n;i++){
            result = lastN1 + lastN2;
            lastN1 = lastN2;
            lastN2 = result;
        }
        return result;
    }
}
