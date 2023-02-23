/*

57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

*/

class Solution {
    public int[][] merge(ArrayList<int[]> intervals, int newInterval[])
    {
        ArrayList<int[]> finalIntervals = new ArrayList<int[]>();
        int prev[] = new int[2];
        prev[0] = intervals.get(0)[0];
        prev[1] = intervals.get(0)[1];
        for( int i = 1;i<intervals.size();i++)
        {
            if( prev[1] >= intervals.get(i)[0] )
            {
                prev[0] = Math.min( prev[0], intervals.get(i)[0] );
                prev[1] = Math.max( prev[1], intervals.get(i)[1] );
            }    
            else
            {
                finalIntervals.add( prev );
                prev = prev = intervals.get(i);
            }    
        }
        finalIntervals.add( prev );

        if( newInterval[0] > finalIntervals.get(finalIntervals.size()-1)[1])
            finalIntervals.add( newInterval );
        if( newInterval[0] < finalIntervals.get(0)[0] && newInterval[1] < finalIntervals.get(0)[0])
            finalIntervals.add( 0, newInterval );

        int ans[][] = new int[finalIntervals.size()][2];
        for( int i = 0; i < finalIntervals.size();i++)
        {
            ans[i][0] = finalIntervals.get(i)[0];
            ans[i][1] = finalIntervals.get(i)[1];
        }
        return ans;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*if( intervals.length == 0 )
        {
            int ans[][] = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }

        ArrayList<int[]> Intervals = new ArrayList<int[]>();
        int flag = 0;
        for(int i=0;i< intervals.length;i++ )
        {
            if( intervals[i][0] <= newInterval[0] || flag == 1)
                Intervals.add(intervals[i]);
            else
            {
                int ans[] = new int[2];
                ans[0] = newInterval[0];
                ans[1] = newInterval[1];
                Intervals.add(ans);
                Intervals.add(intervals[i]);
                flag=1;
            }             
        }
        if( flag == 0 )
        {
            int ans[] = new int[2];
            ans[0] = newInterval[0];
            ans[1] = newInterval[1];
            Intervals.add(ans);
        }
        return merge(Intervals, newInterval );*/

        ArrayList<int[]> FinalIntervals = new ArrayList<int[]>();
        int i = 0;
        while( i < intervals.length )
        {
            if( newInterval[0] > intervals[i][0])
            {
                FinalIntervals.add(intervals[i]);
                i++;
            }    
            else
                break;
        }

        if( FinalIntervals.size() == 0 || newInterval[0] > FinalIntervals.get(FinalIntervals.size()-1)[1] )
            FinalIntervals.add( newInterval );
        else
        {
            int[] lastInterval = FinalIntervals.get(FinalIntervals.size()-1);
            lastInterval[1] = Math.max(lastInterval[1],newInterval[1]);
        }

        while( i < intervals.length )
        {
            int[] lastInterval = FinalIntervals.get(FinalIntervals.size()-1);
            if( lastInterval[1] >= intervals[i][0] )
                lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);  
            else
                FinalIntervals.add(intervals[i]);
            i++;
        }

        int ans[][] = new int[FinalIntervals.size()][2];
        for( i = 0; i < FinalIntervals.size();i++)
        {
            ans[i][0] = FinalIntervals.get(i)[0];
            ans[i][1] = FinalIntervals.get(i)[1];
        }
        return ans;
    }
}
