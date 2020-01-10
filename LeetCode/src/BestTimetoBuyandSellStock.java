/**
 * Created by ybao on 17/3/25.
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = new BestTimetoBuyandSellStock().maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i] - min);
            }

        }
        return maxProfit;
    }
}
