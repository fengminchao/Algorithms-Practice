import java.util.ArrayList;
import java.util.List;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        List<Integer> r =new GetLeastNumbers_Solution().GetLeastNumbers_Solution(arr,4);
        System.out.println(r);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (k > input.length || k <= 0){
            return list;
        }
        for (int n : input){
            if (list.size() < k){
                boolean b = false;
                for (int i = list.size() - 1;i >= 0;i--){
                    if (list.get(i) < n){
                        b = true;
                        list.add(i + 1,n);
                        break;
                    }
                }
                if (!b){
                    list.add(0,n);
                }
            }else {
                for (int i = 0;i< list.size();i++){
                    if (list.get(i) > n){
                        list.remove(list.size() - 1);
                        list.add(i,n);
                        break;
                    }
                }
            }
        }
        return list;
    }
}
