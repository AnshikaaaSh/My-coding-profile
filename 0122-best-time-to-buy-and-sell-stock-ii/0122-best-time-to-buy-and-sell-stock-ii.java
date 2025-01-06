class Solution {
    public int maxProfit(int[] prices) {
        int frontBuy=0, frontNotBuy=0;
        int currBuy=0, currNotBuy=0;
        int n=prices.length;
        for(int i=n-1;i>=0;i--){
            currBuy=Math.max(-prices[i]+frontNotBuy, frontBuy);
            currNotBuy=Math.max(prices[i]+frontBuy, frontNotBuy);

            frontBuy=currBuy;
            frontNotBuy=currNotBuy;
        }
        return frontBuy;
    }
}