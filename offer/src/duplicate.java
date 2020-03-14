public class duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || length == 0){
            return false;
        }
        boolean[] b = new boolean[length];
        for (int i = 0;i < numbers.length;i++){
            if (b[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }
            b[numbers[i]] = true;
        }
        return false;
    }
}
