/*
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

*/

class PermutationInString {
    private boolean check(int[] freqA, int[] freqB){
        for(int i=0;i<26;i++){
            if(freqA[i]!=freqB[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0;
        int freqS1[] = new int[26];
        int freqS2[] = new int[26];

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            freqS1[ch-'a']++;
        }

        while(r<s2.length()){
            char ch = s2.charAt(r);
            freqS2[ch-'a']++;

            if(freqS2[ch-'a']>freqS1[ch-'a']){
                while(l<=r && freqS2[ch-'a']>freqS1[ch-'a']){
                    char charAtL = s2.charAt(l);
                    freqS2[charAtL-'a']--;
                    l++;
                }
            }
            if(check(freqS1,freqS2) && (r-l+1)==s1.length()){
                return true;
            }
            r++;
        }
        return false;
    }
}
