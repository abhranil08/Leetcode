class binaryArrayfindMaxSubarrayWithZeroSum {
    public int findMaxSubarrayWithZeroSum(int nums[])
    {
        HashMap<Integer,Integer> h = new HashMap<>();
        int sum=0,max=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum==0)
                max=i+1;
            if(h.containsKey(sum))
            {
                max=Math.max(max,i-h.get(sum));
            }
            else
            h.put(sum,i);
                
        }
        return max;
    }
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                nums[i]=-1;
        }
        return findMaxSubarrayWithZeroSum(nums);
        
    }
}
