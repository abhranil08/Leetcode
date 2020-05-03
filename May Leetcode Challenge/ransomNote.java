class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    
        //Using hashing concept using frequency array because cases consists of only letters, that too only the lowercase letters.
        
        int n1=ransomNote.length(); int n2=magazine.length();
        
        int freqA[]= new int[26]; int freqB[]= new int[26];
        
        for(int i=0;i<n1;i++)
        {
            char ch=ransomNote.charAt(i);
            freqA[(int)ch-97]++;
        }
        
        for(int i=0;i<n2;i++)
        {
            char ch=magazine.charAt(i);
            freqB[(int)ch-97]++;
        }
        
        for(int i=0;i<26;i++)
        {
            if(freqA[i]>freqB[i])
                return false;
            else
                freqA[i]=0;
            
        }
        for(int i=0;i<26;i++)
        {
            if(freqA[i]!=0)
                return false;
        }
        return true;
        
    }
}
