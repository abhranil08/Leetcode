class Solution {
    
    public int findJudge(int N, int[][] trust) {
        
        boolean trustsSomeone[]=new boolean[N+1];
        
        HashSet[] dp=new HashSet[N+1];
        
        for(int i=0;i<=N;i++)
            dp[i]=new HashSet<Integer>();
        
        int n=trust.length;
        for(int i=0;i<n;i++)
        {
            int a=trust[i][0];
            int b=trust[i][1];
            dp[b].add(a);
            trustsSomeone[a]=true;
            
        }
        
        
        int answer=-1;
        for(int i=1;i<=N;i++)
        {
            if(dp[i].size()==(N-1) && trustsSomeone[i]==false)
            {
                if(answer==-1)
                    answer=i;
                else
                    return -1;
            }
        }
        return answer;
        
    }
}
