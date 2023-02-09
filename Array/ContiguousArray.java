class Solution {
    public int findMaxLength(int[] nums) {
        HashMap< Integer, Integer > h = new HashMap<>();
        h.put(0,-1);
        int maxLength = 0, currSum = 0, number;

        for(int i = 0;i<nums.length;i++)
        {
            if( nums[i]==0)
                number = -1;
            else
                number = 1;
            currSum += number;

            if( h.containsKey( currSum ))
            {
                int lastIndex = h.get( currSum );
                maxLength = Math.max( maxLength, i - lastIndex );
            }
            else
            {
                h.put( currSum, i);
            }
            
        }
        return maxLength;

        
    }
}
