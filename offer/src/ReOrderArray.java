import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 新开个数组，前面顺序插入奇数，后面倒序插入偶数
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int index = 0;
        int[] tempArr = Arrays.copyOf(array,array.length);
        for (int i = 0;i < array.length;i++){
            if (tempArr[i] % 2 == 1){
                array[index] = tempArr[i];
                index++;
            }
        }
        index = array.length - 1;
        for (int i = array.length - 1;i >= 0;i--){
            if (tempArr[i] % 2 == 0){
                array[index] = tempArr[i];
                index--;
            }
        }
    }

}
