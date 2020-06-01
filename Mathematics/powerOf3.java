/* 

Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?

*/

/*
Algorithm
This algorithm only works since 3 is a prime number.

3^19 = 1162261467 is the biggest power of 3 less than Integer.MAX_VALUE.
Since 3 is a prime number, the only divisors of 319 are 3^0, 3^1, 3^2, ... 3^19, which happen to all be powers of 3.
Return true if n is positive and 3^19 is divisible by n
*/

class powerOf3 {
    public boolean isPowerOfThree(int n) {
        return n>0 && Math.pow(3,19)%n==0;
        
    }
}
