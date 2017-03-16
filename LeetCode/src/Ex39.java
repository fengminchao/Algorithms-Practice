import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by ybao on 17/3/15.
 */
public class Ex39 {

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        int target = 7;
        List<List<Integer>> numList = new Ex39().combinationSum(nums,target);
        System.out.println(numList);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> numList = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return numList;
        }
        solute(candidates,target,numList,new ArrayList<>(),0);
        return numList;
    }

    private void solute(int[] candidates, int target, List<List<Integer>> numList, List<Integer> list, int index) {
        if (target == 0){
            numList.add(new ArrayList<>(list));
            return;
        }
        if (target < 0){
            return;
        }

        for (int i = index;i < candidates.length;i ++){
            list.add(candidates[i]);
            solute(candidates,target - candidates[i],numList,list,i);
            list.remove(list.size() - 1);
        }
    }

}
