class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Update minimum price seen so far
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Update maximum profit if selling today gives a higher profit
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}