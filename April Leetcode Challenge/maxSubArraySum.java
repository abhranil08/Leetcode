class maxSubArraySum {
    // Kadane
    public int maxSubArray(int[] nums) {
        int sumEndingHere=nums[0];
        int sumSoFar=0;
        for(Integer i:nums)
        {
            sumSoFar+=i;
            sumEndingHere=Integer.max(sumSoFar,sumEndingHere);
            if(sumSoFar<0)
                sumSoFar=0;
            
        }
        return sumEndingHere;
        
    }
}
