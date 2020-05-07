class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0],a=prices[0];
        int sum=0;
        for(int i=1;i<prices.length;i++)
        {
           if(prices[i]>a)
           {
               a=prices[i];
           }
            else
            {
                sum+=a-min;
                //System.out.println(a+" "+min);
                //System.out.println(a-min);
                min=prices[i];
                a=min;
            }
               
        }
        if(a>min)
            sum+=a-min;
        /*if(sum==0)
            return a-min;*/
        return sum;
        
        
    }
}
