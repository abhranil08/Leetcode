class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        int freq[] = new int[130];
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            freq[(int)ch]++;
        }
        for(int i=0;i<130;i++)
        {
            if( freq[i] % 2 == 0)
            {
                count += freq[i];
            }
            else if( freq[i]>1 )
                count += (freq[i] - (freq[i]%2)) ;       
        }
        if( count < s.length( ))
            return count+1;
        return count;
        
    }
}
