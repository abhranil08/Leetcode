class moveZero {
    public void moveZeroes(int[] nums) {
        int i=0;
        for(Integer j:nums)
        {
            if(j!=0)
                nums[i++]=j;
        }
        while(i<nums.length)
            nums[i++]=0;
        
        
    }
}
