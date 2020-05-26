class uncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n=A.length;
        int m=B.length;
        
        int dp[][]=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                int count=0;
                if(A[i]==B[j])
                    count=1+dp[i+1][j+1];
                dp[i][j]=Math.max(dp[i+1][j],Math.max(dp[i][j+1],count));
                    
            }
        }
    
        
        /*for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                System.out.print(dp[i][j]+" ");*/
        
        return dp[0][0];
        
    }
}
