/*
Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 
Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?

*/

class Solution {
    public int findDuplicate(int[] nums) {
        
        // Slow pointer fast pointer solution
        int slow = 0, fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow==fast)
                break;
        }

        int slow_2 = 0;

        while(true){
            slow = nums[slow];
            slow_2 = nums[slow_2];

            if(slow==slow_2)
                break;
        }
        return slow; 
    }


    /*
    2nd approach - Mark visited element negative
    Time Complexity: O(n)
    Space Complexity: O(1)

    // check if element at index is already marked as negetive or not
    1 - element at index 1 = 3 not marked as negative, now mark as negative, so array [1,-3,4,2,2]
    3 - element at index 3 = 2 not marked as negative, now mark as negative, so array [1,-3,4,-2,2]
    4 - element at index 4 = 2 not marked as negative, now mark as negative, so array [1,-3,4,-2,-2]
    2 - element at index 2 = 4 not marked as negative, now mark as negative, so array [1,-3,-4,-2,-2]
    2 - element at index 2 = 4 this is marked as negative, so already visited -> return duplicate

    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }
    */
}
