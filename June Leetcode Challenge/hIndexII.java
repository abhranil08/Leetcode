/*

Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

*/

class hIndexII {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int n=citations.length;
        for(int i=0;i<n;i++)
        {
            if(citations[i]>=(n-i))
                return n-i;
        }
        return 0;
    }
}
