class Solution {
    public int lengthOfLongestSubstring(String s) {

        String window = "";
        String longestSubstring = "";
        int maxLength = -1;
        for( int i = 0; i < s.length(); i++ )
        {
            String ch = String.valueOf(s.charAt(i));
            if( window.contains(ch))
            {
                window = window.substring(window.indexOf(ch)+1);
            }

            window += ch;
            
            if( window.length() > maxLength)
            {
                longestSubstring = window;
                maxLength = window.length();
            }
        }
        return longestSubstring.length();      
    }
}
