/*

Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].


*/






/*class Graph {
    int v;
    public List<Integer> adj[];
    Graph(int v)
    {
        this.v=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]= new LinkedList();
        
    }
    void addEdge(int a,int b)
    {
        adj[a].add(b);
        adj[b].add(a);
    }
}*/

class Bipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer> adj[]=new LinkedList[N+1];
        for(int i=0;i<=N;i++)
            adj[i]=new LinkedList();
        
        for(int i=0;i<dislikes.length;i++)
        {
            adj[dislikes[i][0]].add(dislikes[i][1]);
            adj[dislikes[i][1]].add(dislikes[i][0]);
            
        }
        int group[]=new int[N+1];
        for(int i=1;i<=N;i++)
        {
            if(group[i]==0 && !dfs(adj,group,i,1,N))
                return false;
            
        }
        return true;
        
    }
    
    public boolean dfs(List<Integer> adj[],int[] group,int index, int g, int N)
    {
        if(group[index]==g)
            return true;
        if(group[index]==-g)
            return false;
        group[index]=g;
        for(int i:adj[index])
        {
            if(group[i]==g)
                return false;
            if(group[i]==0 && !dfs(adj,group,i,-g,N))
                return false;
        }
        return true;
    }
}
