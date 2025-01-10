class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                for(int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(0, 1, prices, dp, 0,k);
    }
    private int helper(int index, int buy, int[] prices, int[][][] dp, int tag,int cap){
        if(index == prices.length || tag == cap){
            return 0;
        }
        if(dp[index][buy][tag] != -1){
            return dp[index][buy][tag];
        }
        int profit = 0;
        if(buy == 1){
            int buyProfit = helper(index + 1, 0, prices, dp, tag,cap) - prices[index];
            int skipProfit = helper(index + 1, 1, prices, dp, tag,cap);
            profit = Math.max(buyProfit, skipProfit);
        }
        else{
            int sellProfit = helper(index + 1, 1, prices, dp, tag + 1,cap) + prices[index];
            int skipProfit = helper(index + 1, 0, prices, dp, tag,cap);
            profit = Math.max(sellProfit, skipProfit);
        }
        dp[index][buy][tag] = profit;
        return profit;
    }
}