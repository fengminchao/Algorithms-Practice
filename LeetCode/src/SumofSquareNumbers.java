public class SumofSquareNumbers {
    public static void main(String[] args) {
        boolean r =new SumofSquareNumbers().judgeSquareSum(5);
        System.out.println(r);
    }
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        int min = 0;
        while (min <= max){
            int r = min * min + max * max;
            if (r == c){
                return true;
            }else if (r < c){
                min++;
            }else {
                max--;
            }
        }
        return false;
    }
}
