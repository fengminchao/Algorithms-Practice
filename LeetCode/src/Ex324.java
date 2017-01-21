import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ybao on 17/1/21.
 */
public class Ex324 {

    public static void main(String[] args) {

        int[] i1 = {1, 3, 2, 2, 3, 1};
        int[] i2 = {1, 5, 1, 1, 6, 4};

        wiggleSort(i1);
        wiggleSort(i2);

    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length == 2) {
            if (nums[0] == nums[1]) {
                System.out.println("has no valid answer");
                return;
            }
            System.out.println(Arrays.toString(nums));
        } else if (length > 2) {
            int[] nums2 = Arrays.copyOfRange(nums, (length + 1) / 2, length);
            if (nums2[0] == nums[1]) {
                System.out.println("has no valid answer");
                return;
            }
            int m = nums.length % 2 == 0 ? nums2.length - 2 : nums2.length - 1;
            for (int i = (length - 1) / 2; i > 0; i--) {
                nums[i * 2] = nums[i];
                nums[i * 2 - 1] = nums2[m];
                m--;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
