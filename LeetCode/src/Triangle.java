import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3,4);
        List<Integer> list3 = Arrays.asList(6,5,7);
        List<Integer> list4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        int result = new Triangle().minimumTotal(triangle);
        System.out.println(result);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2;i >= 0;i--){
            for (int j = 0;j < triangle.get(i).size();j++){
                triangle.get(i).set(j,Math.min(triangle.get(i + 1).get(j),triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
