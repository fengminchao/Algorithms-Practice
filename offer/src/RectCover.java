public class RectCover {
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int sum = 2;
        int last = 1;
        for (int i = 3;i <= target;i++){
            sum += last;
            last = sum - last;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "%.1f";
        System.out.println(String.format(s,trans(9480823.3f)));
        System.out.println(String.format(s,9480823.3f));
    }

    static float trans(float n){
        return n / 10;
    }
}
