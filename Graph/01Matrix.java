class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ansMat[][]=new int[n][m];

        int max = n+m, first, second;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                first=max; second=max;
                if(mat[i][j]==0) continue;
                else
                {
                    if(i>0)
                    first = mat[i-1][j];
                    if(j>0)
                    second = mat[i][j-1];
                    mat[i][j]=Math.min(first,second)+1;
                }
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                first=max; second=max;
                if(mat[i][j]==0) continue;
                else
                {
                    if(i<n-1)
                    first = mat[i+1][j];
                    if(j<m-1)
                    second = mat[i][j+1];
                    mat[i][j]=Math.min(Math.min(first,second)+1,mat[i][j]);
                }
            }
        }
        return mat;
    }
}
