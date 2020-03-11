//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        int[] n = {4,2,1,4,2,4};
        int r = new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(n);
        System.out.println(r);
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int last = array[0];
        int lastNum = 1;
        for (int i = 1;i<array.length;i++){
            if (last == array[i]){
                lastNum++;
            }else {
                if (lastNum == 1){
                    last = array[i];
                }else {
                    lastNum--;
                }
            }
        }
        lastNum = 0;
        for (int i : array){
            if (i == last){
                lastNum++;
            }
        }
        if (lastNum > array.length/2){
            return last;
        }else {
            return 0;
        }
    }
}
