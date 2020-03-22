public class GasStation {
    public static void main(String[] args) {
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (min > sum) {
                min = sum;
                minIndex = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return (minIndex + 1) % gas.length;
    }

}
