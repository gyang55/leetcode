package LeetCode.backtracking;

public class JZ63 {
    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少?
     * <p>
     * 思路：：用一个变量记录当日前的最低价，记为cost。当日卖的利润 price - cost。前一日以前的最大利润已经算出，则取大
     */

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices
        ) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

}
