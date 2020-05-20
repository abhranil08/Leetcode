class productOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int dpr[]=new int[nums.length];
        int dpl[]=new int[nums.length];
        int n=nums.length;
        //Arrays.fill(dpr,nums[n-1]);
        //Arrays.fill(dpl,nums[0]);
        dpr[0]=nums[0];
        dpl[n-1]=nums[n-1];
        
        for(int i=1;i<n;i++)
        {
            dpr[i]=dpr[i-1]*nums[i];
            System.out.println(dpr[i]);
        }
        for(int i=n-2;i>=0;i--)
            dpl[i]=dpl[i+1]*nums[i];
        
        int dp[]=new int[nums.length];
        
        for(int i=1;i<n-1;i++)
            dp[i]=dpl[i+1]*dpr[i-1];
        dp[0]=dpl[1];
        dp[n-1]=dpr[n-2];
        return dp;
            
        
    }
}
