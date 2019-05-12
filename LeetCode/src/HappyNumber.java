import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = 0;
            while (n > 0){
                int t = n % 10;
                sum += t * t;
                n /= 10;
            }
            if (set.contains(sum)){
                return sum == 1;
            }else {
                set.add(sum);
            }
            n = sum;
        }
    }

    public static void main(String[] args){
        boolean result = new HappyNumber().isHappy(19);
        System.out.println(result);
    }
}
