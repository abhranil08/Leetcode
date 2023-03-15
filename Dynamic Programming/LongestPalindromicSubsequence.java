class Solution {
    public int lcs( String str1, String str2 )
    {
        int n1 = str1.length();
        int n2 = str2.length();
        int dp[][]=new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                if( str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][]=new int[n+1][n+1];

        for(int i=0;i<n;i++)
            dp[i][i]=1;

        for( int c=2;c<=n;c++)
        {
            for(int i=0;i<n-c+1;i++)
            {
                int j=i+c-1;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];

        /*String reverseStr = "";
        for(int i=0;i<s.length();i++)
            reverseStr = s.charAt(i) + reverseStr;

        return lcs(s, reverseStr);*/
    }
}
