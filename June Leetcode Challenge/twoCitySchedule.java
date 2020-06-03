class twoCitySchedule {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->
                    {
                      return (a[0]-a[1])-(b[0]-b[1]);  
                    });
        int n=costs.length/2;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=costs[i][0];
            sum+=costs[i+n][1];
        }
        return sum;
        
    }
}
