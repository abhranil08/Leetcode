class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][]=new int[n+1][amount+1];
        Arrays.sort(coins);
        for(int j=1;j<=amount;j++)
        {
            dp[0][j] = (int)1e5;           
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(j>=coins[i-1])
                    dp[i][j]=Math.min( dp[i][j], dp[i][j-coins[i-1]]+1 );
            }
        }
        return dp[coins.length][amount] > ( 1e4 ) ? -1:dp[coins.length][amount];
    }
}
