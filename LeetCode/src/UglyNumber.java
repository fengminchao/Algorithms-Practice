public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        while (true){
            if (num == 1){
                return true;
            }
            if (num % 5 == 0){
                num /= 5;
                continue;
            }
            if (num % 3 == 0){
                num /= 3;
                continue;
            }
            if (num % 2 == 0){
                num /= 2;
                continue;
            }
            return false;
        }
    }

    public static void main(String[] args){
        boolean result = new UglyNumber().isUgly(6);
        System.out.println(result);
    }
}
