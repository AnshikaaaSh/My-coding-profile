class Solution {
    public int maxProfit(int[] prices) {
        // Initialize states
        int buy1 = Integer.MIN_VALUE; // Max profit after 1st buy
        int sell1 = 0;                // Max profit after 1st sell
        int buy2 = Integer.MIN_VALUE; // Max profit after 2nd buy
        int sell2 = 0;                // Max profit after 2nd sell

        // Iterate through each day's price
        for (int price : prices) {
            // Update states
            buy1 = Math.max(buy1, -price);         // Either keep previous buy1 or buy at current price
            sell1 = Math.max(sell1, buy1 + price); // Either keep previous sell1 or sell at current price
            buy2 = Math.max(buy2, sell1 - price); // Either keep previous buy2 or buy at current price
            sell2 = Math.max(sell2, buy2 + price); // Either keep previous sell2 or sell at current price
        }

        // Return max profit after completing two transactions
        return sell2;
    }
}
