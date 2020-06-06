class randomPickAWeight {
    
    double weight[];
    double probability[];

    public Solution(int[] w) {
        double sum=0.0;
        weight = new double[w.length];
        probability = new double[w.length];
        
        for(int i=0;i<w.length;i++)
        {
            weight[i]=w[i];
            sum+=weight[i];
        }
        
        //System.out.println(pro)
        probability[0]=weight[0]/sum;
        
        for(int i=1;i<w.length;i++)
        {
            weight[i]+=weight[i - 1];
            probability[i]=weight[i]/sum;
        }   
        
    }
    
    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(probability, Math.random())) - 1;
    }
}

/**
 * Your randomPickAWeight object will be instantiated and called as such:
 * randomPickAWeight obj = new randomPickAWeight(w);
 * int param_1 = obj.pickIndex();
 */
