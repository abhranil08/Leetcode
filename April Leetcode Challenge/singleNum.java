class singleNum {
    public int singleNumber(int[] nums) {
        int s=0;
        // xor solution
        for(Integer i:nums)
            s=s^i;
        return s;
        
    }
}
