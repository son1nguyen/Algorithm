package Easy;

/**
 * Created by sonnguyen on 4/8/18.
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions
     * as you like (ie, buy one and sell one share of the stock multiple times). However, you
     * may not engage in multiple transactions at the same time (ie, you must sell the stock
     * before you buy again).
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += (prices[i] - prices[i - 1] > 0) ? prices[i] - prices[i - 1] : 0;
        }
        return profit;
    }
}
