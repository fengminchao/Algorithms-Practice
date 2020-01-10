/**
 * Created by ybao on 17/2/12.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater e = new ContainerWithMostWater();
        int[] height = {1, 2, 4, 3};
        System.out.println(e.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right && left >= 0 && right <= height.length - 1) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
