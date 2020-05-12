class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        /* Simple Solution - O(n)
            if(nums.length==1)
                return nums[0];
            if(nums[0]!=nums[1])
                return nums[0];
            for(int i=1;i<nums.length-1;i++)
            {
                if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1])
                    return nums[i];
            }
            return nums[nums.length-1];
        */
        
        
        // Binary Search Solution - O(log n)
        
        int low=0,high=nums.length-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(mid%2==0)
            {
                if(nums[mid]==nums[mid+1])
                    low=mid+2;
                else
                    high=mid;
            }
            else
            {
                if(nums[mid]==nums[mid-1])
                    low=mid+1;
                else
                    high=mid-1;
            }          
        }
        return nums[low];     
    }
}
