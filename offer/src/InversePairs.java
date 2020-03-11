//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
public class InversePairs {
    private int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int i, int end) {
        if (i == end) {
            return;
        }
        mergeSort(array, i, (i + end) / 2);
        mergeSort(array, (i + end) / 2 + 1, end);
        merge(array, i, end);
    }

    private void merge(int[] array, int start, int end) {
        int[] temp = new int[end - start + 1];
        int mid = (start + end) /2;
        int endIndex = mid + 1;
        int k = 0,startIndex = start;
        while (startIndex <= mid || endIndex <= end){
            int n1 = startIndex <= mid ? array[startIndex] : Integer.MAX_VALUE;
            int n2 = endIndex <= end ? array[endIndex] : Integer.MAX_VALUE;
            if (n2 < n1){
                temp[k++] = n2;
                count = (count + mid - startIndex + 1) % 1000000007;
                endIndex++;
            }else {
                temp[k++] = n1;
                startIndex++;
            }
        }
        for (int i = 0;i < temp.length;i++){
            array[start + i] = temp[i];
        }
    }
}
