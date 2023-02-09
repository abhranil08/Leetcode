class Pair {
    int coord1, coord2;

    public Pair( int x, int y )
    {
        this.coord1 = x;
        this.coord2 = y;
    }
}

class IntervalComparator implements Comparator< Pair >
    {
        @Override
        public int compare(Pair p1, Pair p2)
        {
            if( p1.coord1 < p2.coord1 )
                return -1;
            else if( p1.coord1 == p2.coord1 )
                if( p2.coord2 < p1.coord2)
                    return -1;
                else if( p2.coord2 > p1.coord2 )
                    return 1;
                else
                    return 0;
            else
                return 1;
        }
    }

class Solution {
    
    public int[][] merge(int[][] intervals) {
        Pair intervalsArr[] = new Pair[intervals.length];
        List<int[]> overlappingPair = new ArrayList<>();
        for( int i = 0;i<intervals.length;i++)
        {
            intervalsArr[i]=new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(intervalsArr, new IntervalComparator() );
        for( int i = 0; i < intervals.length; i++ )
        {
            Pair point = intervalsArr[ i ];
        }

        Pair prevPoint = intervalsArr[0];
        for( int i = 1; i < intervals.length; i++ )
        {
            Pair point = intervalsArr[ i ];
            if( point.coord1 <= prevPoint.coord2 )
            {
                prevPoint = new Pair(prevPoint.coord1,Math.max(point.coord2, prevPoint.coord2));
            }
            else
            {
                overlappingPair.add(new int[]{prevPoint.coord1,prevPoint.coord2});
                prevPoint = point;
            }
        }
        overlappingPair.add(new int[]{prevPoint.coord1,prevPoint.coord2});      
        return overlappingPair.toArray(new int[][]{});   
    }
}
