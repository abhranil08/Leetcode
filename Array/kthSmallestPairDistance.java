/*

Given an integer array, return the k-th smallest distance among all the pairs. 
The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 

Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

*/

class kthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        //After sorting maximum difference ---> last element - first element
        int low=nums[1]-nums[0],high=nums[nums.length-1]-nums[0];
        
        // As array sorted, Minimum difference ---> lowest of difference of adjacent elements
        for(int i=1;i<nums.length-2;i++)
        {
            if((nums[i+1]-nums[i])<low)
                low=nums[i+1]-nums[i];
        }        
        int mid=0;
        while(low<high)
        {
            mid=(high+low)/2;
            int countPairs=0,index=0;
            
            //number of pairs(A,B) ---> difference less than equal to mid
            for(int i=0;i<nums.length;i++)
            {
                while(true)
                {
                    int difference=nums[i]-nums[index];
                    if(difference>mid)
                        index++;
                    else
                        break;
                }
                countPairs+=(i-index);   
            }
            
            if(countPairs>=k)
                high=mid;
            else
                low=mid+1;
        }
        return low;
        
    }
}
