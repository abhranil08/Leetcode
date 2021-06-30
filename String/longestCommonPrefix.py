"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings."""


class Solution:
        
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        def findPrefix( str1, str2 ):
            position = 0
            for position in range( 0 , min( len( str1 ), len( str2 ) ) ):                
                if str1[ position ] != str2[ position ]:
                    position -=1
                    break
            return position
    
        minL = sys.maxsize
        minStr = ""        
        
        for i in strs:
            if len( i ) < minL :
                minL = len( i )
                minStr = i
        
        minPrefix = len( minStr )
        
        flag = True        
        for i in strs:
            if( len( i ) > 0 and len( minStr ) > 0 ):
                if( i[ 0 ] != minStr[ 0 ] ):
                    return( "" )
                
            Prefix = findPrefix( i, minStr )
            minPrefix = min( Prefix , minPrefix )
                           
        return minStr[ :minPrefix+1 ]
