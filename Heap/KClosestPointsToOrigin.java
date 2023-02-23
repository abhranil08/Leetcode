/*

973. K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

*/

class Point{
    int coord1, coord2;
    Point( int coord1, int coord2)
    {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }
}
class ComparatorPoints implements Comparator<Point>{
    @Override
    public int compare( Point p1, Point p2 )
    {
        int d1 = (int)(Math.pow( p1.coord1 , 2 ) + Math.pow( p1.coord2 , 2 ));
        int d2 = (int)(Math.pow( p2.coord1 , 2 ) + Math.pow( p2.coord2 , 2 ));

        if( d1 < d2 )
            return -1;
        else
            return 1;
    }
}
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        /*Point pointArr[] = new Point[points.length];
        int kPts[][]=new int[k][2];
        for(int i = 0;i<points.length;i++)
        {
            pointArr[i] = new Point( points[i][0], points[i][1]);
        }
        Arrays.sort(pointArr, new ComparatorPoints());
        for(int i=0;i<k;i++)
        {
            kPts[i][0]=pointArr[i].coord1;
            kPts[i][1]=pointArr[i].coord2;
        }
        return kPts;*/

        PriorityQueue<Point> pq = new PriorityQueue<>(points.length,new ComparatorPoints());
        for(int i = 0 ;i < points.length;i++)
            pq.add( new Point( points[i][0], points[i][1]) );

        int kPts[][]=new int[k][2];
        int i=0;
        while(pq.size()!=0 && i < k)
        {
            Point p = pq.remove();
            kPts[i][0]=p.coord1;
            kPts[i][1]=p.coord2;
            i++;
        }
        return kPts;
        
    }
}
