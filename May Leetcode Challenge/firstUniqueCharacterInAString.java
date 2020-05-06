class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        int freq[]=new int[26];
        
        for(int i=0;i<s.length();i++)
            freq[(int)s.charAt(i)-97]++;
        
        for(int i=0;i<s.length();i++)
        {
            if (freq[(int)s.charAt(i)-97]==1)
                return i;
        }
        return -1;
        
    }
}
