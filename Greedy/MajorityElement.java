class Solution {
    public int majorityElement(int[] nums) {
        /*HashMap<Integer,Integer> elementCount = new HashMap<>();

        int elementFreq = 0, majorityElementCount = 0, majorityElement = nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(elementCount.containsKey(nums[i]))
            {
                elementFreq = elementCount.get(nums[i])+1;
                if(elementFreq > majorityElementCount)
                {
                    majorityElementCount = elementFreq;
                    majorityElement = nums[i];
                }
                elementCount.put(nums[i],elementFreq);
            }    
            else
                elementCount.put(nums[i], 1 );
        }
        return majorityElement;*/

        int majorityElement = nums[0],count =1;
        for( int i = 1 ;i<nums.length;i++)
        {
            if( majorityElement != nums[i])
            {
                count--;
                if( count == 0 )
                {
                    majorityElement = nums[i];
                    count = 1;
                }    
            }
            else
            count++;
        }
        /*for( int i = 0;i<nums.length;i++)
        {
            if(majorityElement == nums[i] )
            majorityElementCount ++;
        }*/

        return majorityElement;
    }
}
