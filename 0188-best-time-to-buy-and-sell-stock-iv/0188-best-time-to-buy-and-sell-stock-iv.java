class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k >= n/2, treat it as unlimited transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP array to store the max profit
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0]; // Tracks max profit for one less transaction
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff); // No transaction vs. selling today
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);  // Update maxDiff for next day
            }
        }

        return dp[k][n - 1]; // Max profit with k transactions by the last day
    }
}
