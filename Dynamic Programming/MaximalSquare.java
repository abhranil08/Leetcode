/*

221. Maximal Square
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

*/


class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int largestSquare = 0;

        int dp[][] = new int[n+1][m+1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(matrix[i-1][j-1] == '1')
                dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]);
                largestSquare = Math.max(dp[i][j], largestSquare);
            }
        }
        return largestSquare*largestSquare;
    }
}
