class lastStoneWt {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i:stones)
            pq.add(i);
        while(pq.size()>=2)
        {
            int a=pq.poll();
            int b=pq.poll();
            if(a!=b)
                pq.add(Integer.max(a,b)-Integer.min(a,b));
            System.out.println(pq);
        }
        if(pq.isEmpty())
            return 0;
        else
            return pq.poll();
        
    }
}
