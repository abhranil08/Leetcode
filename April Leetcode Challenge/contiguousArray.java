class Solution {
    public int findMaxSubarrayWithZeroSum(int nums[])
    {
        int max=0,s=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            s+=nums[i];
            if(s==0)
                max=i+1;
            if(h.containsKey(s))
            {
                max=Math.max(max,i-h.get(s));
            }
            else
                h.put(s,i);
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
