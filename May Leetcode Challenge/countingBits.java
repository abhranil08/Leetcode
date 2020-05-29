class countingBits {
    public int[] countBits(int num) {
        
        /* This solution is also an O(n) solution. But the latter one is easier and compact. I have explained it */
        /*
        int count[]=new int[num+1];
        int total=0;
        Arrays.fill(count,-1);
        for(int i=0;i<=num;i++)
        {
            int n=i;
            int sum=0;
            while(n>0)
            {
                if(count[n]!=-1)
                {
                    sum+=count[n];
                    total+=sum;
                    break;
                }
                if(n%2!=0)
                    sum++;
                n=n/2;
            }
            count[i]=sum;
        }
        return count; */
        
        /* EXPLAINATION :
        Initially, count[0]=0
        For 1, count[1/2] + 1%2 = count[0] + 1 = 0 + 1 = 1 ---> count[0] was initialized before
        For 2, count[2/2] + 2%2 = count[1] + 0 = 1 + 0 = 1 ---> count[1] was calculated above
        For 3, count[3/2] + 3%2 = count[1] + 1 = 1 + 1 = 2 ---> count[1] calculated above
        For 4, count[4/2] + 4%2 = count[2] + 0 = 1 + 0 = 1 ---> count[2] calculated above
        For 5, count[5/2] + 5%2 = count[2] + 1 = 1 + 1 = 2 ---> count[2] calculated above
        
        Dp part explained above, it's somewhat like a fibonacci Dp. 
        Now, coming to the recurrence formula, f[i] = f[i/2] + i%2, you can see that for a particular
        number 'i', there will be two parts in their binary form to find the number of bits: the right most bit and the remaining part.
        The remaining part other than the right most bit represents the number i/2, which can be stored. 
        The right most bit can be found out by finding out the remainder after dividing the number 'i' by 2.
        Ex: for suppose 19, binary form = "10011" ---> after division by 2 (right shift), binary form = "1001" 
            for suppose 18, binary form = "10010" ---> after division by 2 (right shift), binary form = "1001"
            for suppose  9, binary form = "1001"  --->                                    binary form = "1001"
            for 19, right most bit is 1 because odd(not divisible by 2) whereas for 18, right most bit is 0 because even.
            
            for suppose 14, binary form = "1110" ---> after division by 2, binary form = "111"
            for suppose 15, binary form = "1111" ---> after division by 2, binary form = "111"
            for suppose  7, binary form = "111"  --->                      binary form = "111"
            for 15, right most bit is 1 because odd(not divisible by 2) whereas for 14, right most bit is 0 because even.
            
         */
        
        int count[]=new int[num+1];
        for(int i=1;i<=num;i++)
        {
           count[i]=count[i/2]+(i%2); 
        }
        return count;
        
    }
}
