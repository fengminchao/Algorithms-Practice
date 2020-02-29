public class CountingSort {

    public int[] countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        int[] arr = new int[max - min + 1];
        for (int n : nums) {
            arr[n - min]++;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index < arr.length && arr[index] == 0) {
                index++;
            }
            nums[i] = index + min;
            arr[index]--;
        }
        return nums;
    }
}
