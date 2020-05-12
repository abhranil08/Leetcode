class Solution {
    
    public boolean isValid(int i,int j,int [][] image)
    {
        if(i<0 || j<0 || i>=image.length || j>=image[0].length)
            return false;
        else
            return true;
    }
    public void colour(int[][] image, int[][] dp,int i,int j,int newColor, int oldColor)
    {
        if(isValid(i,j,image))
        {
            if(image[i][j]==oldColor && dp[i][j]!=-1)
            {
                image[i][j]=newColor;
                dp[i][j]=-1;
                colour(image,dp,i+1,j,newColor,oldColor);
                colour(image,dp,i-1,j,newColor,oldColor);
                colour(image,dp,i,j+1,newColor,oldColor);
                colour(image,dp,i,j-1,newColor,oldColor);
            }
        }
        else return;
        
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor=image[sr][sc];
        int dp[][]=new int[image.length][image[0].length];
        colour(image,dp,sr,sc,newColor,oldColor);
        return image;
        
    }
}
