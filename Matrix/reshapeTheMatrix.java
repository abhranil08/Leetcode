/*

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 

Example 1:


Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

*/
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        if( r*c != rows*cols)
            return mat;
        
        int newMat[][]=new int[r][c];
        int indexRow=0;
        int indexCol=0;
        
        for(int i=0;i<rows;i++)
        {
            for( int j =0;j<cols;j++)
            {
                newMat[ indexRow ][ indexCol ] = mat[i][j];
                if( indexCol == c - 1 )
                {
                    indexRow++;
                    indexCol=0;
                }
                else
                    indexCol++;
                
            }
        }
        return newMat;
        
    }
}
