/**
 * Created by ybao on 17/4/16.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = new TrappingRainWater().trap(nums);
        System.out.println(result);
    }

    public int trap(int[] height) {
        int maxIndex = findMaxIndex(height);
        int leftCapacity = 0;
        int rightCapacity = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0;i < maxIndex;i++){
           if (height[i] >= leftMax){
              leftMax = height[i];
           }else {
               leftCapacity += leftMax - height[i];
           }
        }

        for (int i = height.length - 1;i > maxIndex;i--){
            if (height[i] >= rightMax){
                rightMax = height[i];
            }else {
                rightCapacity += rightMax - height[i];
            }
        }
        return leftCapacity + rightCapacity;
    }

    private int findMaxIndex(int[] height) {
        int max = 0;
        int index = 0;
        for (int i = 0;i < height.length ; i++){
            if (height[i] > max){
                index = i;
                max = height[i];
            }
        }
        return index;
    }
}
