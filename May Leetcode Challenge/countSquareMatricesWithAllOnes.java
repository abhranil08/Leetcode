class countSquareMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int dp[][]=new int[n+1][m+1];
        int res=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(matrix[i][j]==1)
                {
                    dp[i][j]=1+Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i+1][j+1]);
                    res+=dp[i][j];
                }
            }
        }
        return res;
    }
}
