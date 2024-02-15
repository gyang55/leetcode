package LeetCode.arrays;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i <prices.length ; i++) {
            min = Math.min(min,prices[i]);
            int tempProfit =(prices[i]-min);
            maxProfit=Math.max(maxProfit,tempProfit);
        }

        return maxProfit;
    }
}
