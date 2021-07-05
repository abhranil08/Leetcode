/* Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
*/

class Solution {
    public int countVowelPermutation(int n) {
        long dp[][] = new long[ n + 1 ][ 5 ];
        
        for( int i = 0 ; i < 5 ; i++)
            dp[1][i]=1;
        
        long mod = 1000000007;
        
        int relationship[][] = new int[][] { 
            { 1 }, { 0,2 }, { 0,1,3,4 }, { 2,4 } , { 0 } } ;
        
        for( int i = 1; i < n ; i++)
        {           
            for( int u = 0; u < 5; u++)
            {
                dp[ i + 1 ][ u ] = 0;
                for( int v : relationship[ u ])
                    dp[i+1][u] += dp[ i ][v] % mod;
            }
        }
        long total = 0;
        for( int i = 0 ; i < 5 ; i++)
            total = ( total + dp[ n ][i] ) % mod;
         return (int)total;
    }
    
    
}
