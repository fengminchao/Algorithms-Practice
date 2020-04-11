public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int r = new UniqueBinarySearchTrees().numTrees2(5);
        System.out.println(r);
    }

    int[] arr;
    public int numTrees(int n) {
        if (n < 1){
            return 0;
        }
        arr = new int[n];
        arr[0] = 1;
        return calNums(n);
    }

    public int calNums(int n){
        if (n <= 0 || n > arr.length){
            return 1;
        }
        if (arr[n-1] != 0){
            return arr[n-1];
        }else {
            int sum = 0;
            for (int i = 0;i < n;i++){
                sum += calNums(i) * calNums(n-i-1);
            }
            arr[n-1]=sum;
            return sum;
        }
    }

    public int numTrees2(int n){
        int[] arr = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=0;j<i;j++){
                arr[i]+=arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
}
