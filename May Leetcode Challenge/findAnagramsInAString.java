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
        
        for(int i=0;i<s.length()-n+1;i++)
        {
            String substr=s.substring(i,i+n);
            if(isSameArray(freqP,frequencyArray(substr)))
                output.add(i);
        }
        return output;
        
    }
}
