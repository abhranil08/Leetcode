class point {
    int x,y;
    double distance;
    point(int x,int y,double distance)
    {
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}
class kClosestFromOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<point> pq=new PriorityQueue<>(new Comparator<point>()
            {
                public int compare(point obj1,point obj2)
                {
                    if(obj1.distance<obj2.distance)
                        return -1;
                    else
                        return 1;
                }
            });
        
        for(int[] p:points)
        {
            point obj = new point(p[0],p[1],Math.sqrt((double)p[0]*(double)p[0]+(double)p[1]*(double)p[1]));
            pq.add(obj);
            
        }
        
        
        int result[][]=new int[K][2];
        //System.out.println(pq.poll().x);
        //return result;
        int i=0;
        while(K-->0)
        {
            point p = pq.poll();
            result[i][0]=p.x;
            result[i][1]=p.y;
            i++;
        }
        return  result;
            
    }
}
