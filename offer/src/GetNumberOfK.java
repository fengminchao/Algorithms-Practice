//统计一个数字在排序数组中出现的次数。
public class GetNumberOfK {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,5};
        int r = new GetNumberOfK().GetNumberOfK(arr,4);
        System.out.println(r);
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length==0){
            return 0;
        }
        int len = array.length;
        int start = getNumberOfKIndex(array,k,0,len-1,true);
        if (start == -1){
            return 0;
        }
        int end = getNumberOfKIndex(array,k,0,len-1,false);
        return end-start+1;
    }

    public int getNumberOfKIndex(int[] arr, int k, int start, int end, boolean begin) {
        if (start == end) {
            if (k == arr[start]){
                return start;
            }else {
                return -1;
            }
        }
        int mid = (start + end) / 2 + (begin ? 0 : 1);
        if (arr[mid] > k) {
            return getNumberOfKIndex(arr, k, start, mid - (begin ? 0 : 1), begin);
        } else if (arr[mid] == k) {
            if (begin) {
                return getNumberOfKIndex(arr, k, start, mid, begin);
            } else {
                return getNumberOfKIndex(arr, k, mid, end, begin);
            }
        } else {
            return getNumberOfKIndex(arr, k, mid + 1, end, begin);
        }
    }
}
