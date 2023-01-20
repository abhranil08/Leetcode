/*
There is an undirected star graph consisting of n nodes labeled from 1 to n. 
A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. 
Return the center of the given star graph.
*/

/* Not the best solution because used BFS */

class Solution {
    public int findCenter(int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        int totalEdges = (edges.length) + 1;

        for( int i = 0; i<=totalEdges;i++)
            adjList.add( new ArrayList<>());

        for(int i=0;i<totalEdges-1;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);

        }

        Queue<Integer> q = new LinkedList<>();
        q.add(edges[0][0]);
        boolean visited[] = new boolean[totalEdges+1];
        int centreNode = -1;

        while(!q.isEmpty())
        {
            int currNode = q.poll();
            int countAdj = 0;

            for( int adjNodes : adjList.get( currNode ))
            {
                if(!visited[adjNodes] )
                {
                    q.add(adjNodes);
                    visited[adjNodes] = true;
                    countAdj++;

                }
            }

            if( countAdj != totalEdges -1 )
            {
                for( int adjNodes : adjList.get( currNode ))
                    visited[adjNodes] = false;

            }
            else
            {
                centreNode = currNode;
                break;
            }

        }
        return centreNode;
        
    }
}
