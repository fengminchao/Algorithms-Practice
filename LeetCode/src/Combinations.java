import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>>l = new Combinations().combine(4,3);
        System.out.println(l);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k || n < 1 || k < 1){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        combine(result,list,n,k,1);
        return result;
    }

    public void combine(List<List<Integer>> result,List<Integer> list,int n,int k,int start){
        if (k == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i<=n;i++){
            list.add(i);
            combine(result,list,n,k-1,i+1);
            list.remove(list.size()-1);
        }
    }
}
