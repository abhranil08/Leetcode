class Solution {
    public boolean isPerfectSquare(int num) {
        if((double)Math.abs((int)Math.sqrt(num)-(double)Math.sqrt(num))<0.0000001)
            return true;
        else
            return false;
        
    }
}
