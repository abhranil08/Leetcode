class countingBits {
    public int[] countBits(int num) {
        
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
        return count;
        
    }
}
