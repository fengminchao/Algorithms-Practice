/**
 * Candy
 * <p>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Created by ybao on 17/3/30.
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy[] = new int[n];

        for (int i = 1,num = 1;i < n;i++){
            if (ratings[i] > ratings[i - 1]){
                candy[i] = num++;
            }else {
                num = 1;
            }
        }

        for (int i = n - 2,num = 1;i >= 0;i--){
            if (ratings[i] > ratings[i+1]){
                candy[i] = Math.max(num++,candy[i]);
            }else {
                num = 1;
            }
        }

        int sum = 0;
        for (int num : candy){
            sum += num;
        }
        return sum + n;
    }

    public static void main(String[] args) {
        int[] children = {1,2,4,5,4,3,2,1};
        int result = new Candy().candy(children);
        System.out.println(result);
    }
}
