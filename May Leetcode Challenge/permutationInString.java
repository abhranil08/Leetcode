class permutationInString {
    
    public boolean isSameArray(int a[],int b[])
    {
        for(int i=0;i<26;i++)
            if(a[i]!=b[i])
                return false;
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        int n=s1.length();
        int freqS1[]=new int[26];
        
        //HashSet<Character> h = new HashSet<>();
        
        for(int i=0;i<s1.length();i++)
        {
            freqS1[(int)s1.charAt(i)-'a']++;
            //h.add(s1.charAt(i));
        }
        
        if(s1.length()<=s2.length())
        {
            int freqS2[]=new int[26];
            for(int i=0;i<s1.length();i++)
                freqS2[(int)s2.charAt(i)-'a']++;
            
            if(isSameArray(freqS2,freqS1))
                return true;
            
            boolean previous = false;
            for(int i=s1.length();i<s2.length();i++)
            {
                char ch1 = s2.charAt(i);
                char ch2 = s2.charAt(i-s1.length());
                
                if(ch1==ch2 && previous==true)
                    return true;
                else
                {
                    freqS2[(int)ch2-'a']--;
                    freqS2[(int)ch1-'a']++;
                    //if(!h.contains(ch1))
                    //    previous = false;
                    if(isSameArray(freqS2,freqS1))
                    {
                        previous=true;
                        return true;
                    }
                    else
                        previous=false;
                }
            }
                
        }
        return false;
        
    }
}
