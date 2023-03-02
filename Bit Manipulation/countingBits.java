/*

338. Counting Bits
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?

*/

class Solution {
    public int bits( int n )
    {
        int count=0;
        while( n != 0 )
        {
            n=n&(n-1);
            count++;

        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=1;i<=n; i++)
        {
            //arr[i] = bits( i );
            if( i % 2 == 0 )
            arr[ i ] = arr[ i >> 1];
            else
            arr[ i ] = arr[ i >> 1 ] + 1;
        }
        return arr;
        
    }
}
