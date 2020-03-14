import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals,(i1, i2)->i1[0]-i2[0]);
        List<int[]> res = new ArrayList();
        int index = 0;
        res.add(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            int[] nums = intervals[i];
            if(nums[0] <= res.get(index)[1]){
                res.get(index)[1] = Math.max(nums[1],res.get(index)[1]);
            }else{
                index++;
                res.add(nums);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
