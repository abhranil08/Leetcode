/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length-1;
        
        while( ( end - start ) > k - 1 )
        {
            if( Math.abs( arr[ start ] - x ) <= Math.abs( arr[ end ] - x ) )
                end --;
            else
                start ++;
        }
        
        List<Integer> answer = new ArrayList<Integer>(arr.length);
        for(int i = start;i <= end;i++){
            answer.add(arr[i]);
        }
        return answer;       
                
    }
}
