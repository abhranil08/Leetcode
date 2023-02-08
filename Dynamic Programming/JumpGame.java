class Solution {
    public boolean canJump(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        if( dp[0]==0 && nums.length > 1 )
            return false;

        int i = 1;
        while( i < nums.length - 1 )
        {
            dp[i] = Math.max( dp[i-1]-1, nums[i]);
            if( dp[i] == 0 )
                return false;
            i++;
        }
        return true;       
    }
}
