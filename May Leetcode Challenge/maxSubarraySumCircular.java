class Solution {
    public int Kadane(int a[])
    {
        // Kadane - Max contigious subarray sum
        int sumTillHere=0,maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<a.length;i++)
        {
            sumTillHere+=a[i];
            maxSum=Math.max(sumTillHere,maxSum);
            
            if(sumTillHere<0)
                sumTillHere=0;
            
        }
        return maxSum;
    }
    public int maxSubarraySumCircular(int[] A) {
        int n=A.length;
        int maxSumWithoutWrap = Kadane(A);
        int maxContiNegativeSum=0;
        
        for(int i=0;i<n;i++)
        {
            maxContiNegativeSum+=A[i];
            A[i]=-A[i];
        }
        maxContiNegativeSum = maxContiNegativeSum + Kadane(A);
        
        // When all numbers negative
        if(maxContiNegativeSum==0)
            return maxSumWithoutWrap;
        
        return Math.max(maxContiNegativeSum,maxSumWithoutWrap);
        
    }
}
