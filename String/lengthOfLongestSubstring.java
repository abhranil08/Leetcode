/*
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:
Input: s = ""
Output: 0
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*HashSet <Character > h1 = new HashSet<>();
        int maxLength = 0;
        String ans = "";
        for( int i = 0; i< s.length(); i ++ )
        {
            char c = s.charAt( i );
            if( !h1.contains( c ) )
            {
                           
                ans = ans + c;
                h1.add( c );                
            }
            else
            {                
                String substr = ans.substring( ans.indexOf( c )+1 );                
                ans = substr+c;
                maxLength = Math.max( maxLength, ans.length() );                                
            }
            maxLength = Math.max( maxLength, ans.length() );
        }
        
        return Math.max( maxLength, ans.length() );*/
        
        HashMap <Character,Integer > h = new HashMap<>();
        int maxLength = 0;
        
        int start = 0;
        for( int end = 0; end < s.length(); end++ )
        {
            char c = s.charAt(end);
            if( h.containsKey( c ))
                start = Math.max( start, h.get( c ) + 1 );
            
            h.put( c, end );
            maxLength = Math.max( maxLength, end - start + 1 );
        }
        return maxLength;
        
    }
}
