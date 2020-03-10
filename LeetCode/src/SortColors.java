import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int n : nums) {
            count[n]++;
        }
        int i = 0, j = 0;
        while (true) {
            if (count[j] > 0){
                count[j]--;
                nums[i]=j;
                i++;
            }else {
                j++;
                if (j>=count.length){
                    break;
                }
            }
        }
    }
}
