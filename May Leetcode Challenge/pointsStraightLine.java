class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double x1=coordinates[0][0];
        double x2=coordinates[1][0];
        double y1=coordinates[0][1];
        double y2=coordinates[1][1];
        
        int n=coordinates.length;
        
        double m=((double)y2-(double)y1)/((double)x2-(double)x1);
        for(int i=2;i<n;i++)
        {
            double x=coordinates[i][0];
            double y=coordinates[i][1];
            double ytrue = m * (x-x1) + y1;
            if(Math.abs(ytrue-y)<=0.00000001)
                continue;
            else
                return false;
        }
        return true;
        
    }
}
