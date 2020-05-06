class Solution {
    public int findEle(int nums[])
    {
        
        // Moore's Voting Algorithm. Space Complexity is constant, which is an advantage over the HashMap solution.
        int index=0,count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[index])
                count++;
            else
                count--;
            if(count==0)
            {index=i;count=1;}
        }
        
        return nums[index];
    }
    public int majorityElement(int[] nums) {
        /*
                HashMap<Integer,Integer> h=new HashMap<>();
                for(Integer i:nums)
                {
                    if(!h.containsKey(i))
                        h.put(i,1);
                    else
                        h.put(i,h.get(i)+1);
                }
                int maxKey=-1, maxVal=-1;
                for(Map.Entry<Integer,Integer> i:h.entrySet())
                {
                    if(i.getValue()>maxVal)
                    {
                        maxKey=i.getKey();
                        maxVal=i.getValue();
                    }
                }
                return maxKey;
        */
        
        return findEle(nums);
        
                // The question stated, "You may assume that the array is non-empty and the majority element always exist in the array". Hence, we don't have to check whether the element found by Moore'voting algorithm is the majority element or not.
        
    }
}
