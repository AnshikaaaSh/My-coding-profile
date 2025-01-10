class Solution {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int[][] dp=new int[k+1][n];

        for(int t=1;t<=k;t++){
            int maxdiff=-prices[0];
            for(int i=1;i<n;i++){
                dp[t][i]=Math.max(dp[t][i-1],prices[i]+ maxdiff);
                maxdiff=Math.max(maxdiff, dp[t-1][i]-prices[i]);
            }
        }
        return dp[k][n-1];
    }
}