class Solution {
    public boolean twoSameArray( int arr1[], int arr2[])
    {
        for(int i=0;i<arr1.length;i++)
        if(arr1[i]!=arr2[i])
            return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new LinkedList<>();
        if( p.length() > s.length() )
            return anagrams;

        int freqA[] = new int[26];
        int freqB[] = new int[26];

        for( int i = 0;i<p.length();i++)
        {
            freqA[s.charAt(i) - 'a']++;
            freqB[p.charAt(i) - 'a']++;
        }
        int low = 0;
        int high = p.length() - 1;

        for(int i = 0;i<s.length()-high;i++)
        {
            if( twoSameArray(freqA,freqB))
                anagrams.add(i);
            
            {
            freqA[s.charAt(i) - 'a']--;
            if(( i + high + 1) < s.length())
                freqA[s.charAt(i+high+1) - 'a']++;
            }
        }
        return anagrams;
        
    }
}
