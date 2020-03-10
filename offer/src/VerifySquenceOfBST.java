//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int len = sequence.length;
        return isBST(sequence,0,len - 1);
    }

    private boolean isBST(int[] arr, int start,int rootIndex) {
        if (rootIndex <= start){
            return true;
        }
        int left = -1;
        for (int i = rootIndex-1;i>=start;i--){
            if (left == -1){
                if (arr[i] < arr[rootIndex]) {
                    left = i;
                }
            }else {
                if (arr[i] > arr[rootIndex]){
                    return false;
                }
            }
        }
        return isBST(arr,left+1,rootIndex-1) && isBST(arr,start,left);
    }
}
