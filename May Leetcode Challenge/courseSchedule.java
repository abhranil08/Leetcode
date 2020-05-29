class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adj[]=new LinkedList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new LinkedList();
        
            
        for(int[] sub:prerequisites)
        {
            int src=sub[1];
            int dest=sub[0];
            adj[src].add(dest);
        }
        
        //Stack<Integer> st = new Stack<>();
        boolean visited[]=new boolean[numCourses];
        //Arrays.fill(visited,-1);
        for(int i=0;i<numCourses;i++)
        {
            if(!dfs(adj,visited,i))
                return false;
        }
        return true;
        
    }
    
    public boolean dfs(List<Integer> adj[],boolean[] visited,int i)
    {
        
        if(visited[i]==false)
        {
            visited[i]=true;
            for(int j: adj[i])
            {
                if(!dfs(adj,visited,j))
                    return false;
            }
        }
        else
            return false;
        visited[i]=false;
        return true;
    }
}
