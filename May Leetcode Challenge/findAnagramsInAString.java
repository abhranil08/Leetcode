class findAnagramsInAString {
    public int[] frequencyArray(String a)
    {
        int freq[]=new int[26];
        for(int i=0;i<a.length();i++)
            freq[(int)a.charAt(i)-'a']++;
        return freq;
    }
    
    public boolean isSameArray(int a[],int b[])
    {
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        
        int freqP[]=frequencyArray(p);
        List<Integer> output=new ArrayList<>();
        
        /*for(int i=0;i<s.length()-n+1;i++)
        {
            String substr=s.substring(i,i+n);
            if(isSameArray(freqP,frequencyArray(substr)))
                output.add(i);
        }*/
        
        if(p.length()<=s.length())
        {
            int freqS[]=new int[26];
            for(int i=0;i<p.length();i++)
                freqS[(int)s.charAt(i)-'a']++;
            
            //int freqS[] = frequencyArray(s.substring(0,p.length()));
            
            if(isSameArray(freqS,freqP))
                output.add(0);
            
            for(int i=p.length();i<s.length();i++)
            {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i-p.length());
                
                if(ch1!=ch2)
                {
                    freqS[(int)ch2-'a']--;
                    freqS[(int)ch1-'a']++;
                }
                
                if(isSameArray(freqS,freqP))
                    output.add(i-p.length()+1);
            }
                
        }
        return output;
        
    }
}
