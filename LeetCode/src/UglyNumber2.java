public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index = 0, index2 = 0,index3 = 0,index5 = 0;
        nums[0] = 1;
        while (index < n - 1){
            int n2 = nums[index2] * 2;
            int n3 = nums[index3] * 3;
            int n5 = nums[index5] * 5;
            int min = Math.min(n2,Math.min(n3,n5));
            if (nums[index] != min){
                nums[++index] = min;
            }
            if (n2 == min){
                index2++;
            }
            if (n3 == min){
                index3++;
            }
            if (n5 == min){
                index5++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args){
        int result = new UglyNumber2().nthUglyNumber(10);
        System.out.println(result);
    }
}
