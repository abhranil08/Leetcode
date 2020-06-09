/*
Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. 
In this scenario, how would you change your code?

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.

*/

class isSubse {
    public boolean isSubsequence(String s, String t) {
        
        int n1=s.length()-1;
        int n2=t.length()-1;
        
        if(s.length()>t.length()) return false;
        if(n1<0) return true;
        while(n2>=0 && n1>=0)
        {
            if(s.charAt(n1)==t.charAt(n2))
            {
                n1--;
                n2--;
            }
            else
                n2--;
        }
        if(n1<0) return true;
        else return false;
    }
}
