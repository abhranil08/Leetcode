class Solution {
    public void addEdges(List<List<Integer>> adjList, int u, int v )
    {
        adjList.get(u).add(v);
    }

    public boolean dfs( int source, List<List<Integer>> adjList, Stack<Integer> st, boolean visited[], boolean pathvisited[])
    {
        for(Integer neighbour : adjList.get(source))
        {
            if(!visited[neighbour])
            {
                visited[neighbour]=true;
                if( dfs(neighbour, adjList, st, visited, pathvisited ) == false ) return false;
                st.push(neighbour);
            }
        }
        return true;
    }

    public boolean hasCycleUtil(int source, List<List<Integer>> adjList, boolean visited[], boolean pathvisited[])
    {
        if(pathvisited[source]) 
            return true;
        if (visited[source])
            return false;

        visited[source]=true;
        pathvisited[source]=true;

        for(Integer neighbour : adjList.get(source))
        {
            if( hasCycleUtil(neighbour, adjList, visited, pathvisited) == true ) 
                return true;    
        }
        pathvisited[source]=false;
        return false;
    }

    public boolean hasCycle(int numCourses, List<List<Integer>> adjList)
    {
        boolean visited[] = new boolean[numCourses];
        boolean pathvisited[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if( hasCycleUtil(i, adjList, visited, pathvisited)) 
                return true;   
        }
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
            List<List<Integer>> adjList = new ArrayList<>();
            boolean visited[] = new boolean[numCourses];
            boolean pathvisited[] = new boolean[numCourses];
            Stack<Integer> st = new Stack<>();

            //creating adjlist
            for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());

            //adding edges
            for(int i=0;i<prerequisites.length;i++)
            {
                addEdges(adjList,prerequisites[i][1],prerequisites[i][0]);
            }

            if(hasCycle(numCourses, adjList))
                return new int[0];
            
            for(int i = 0;i<numCourses;i++)
            {
                if(!visited[i])
                {
                    visited[i]=true;
                    if( dfs(i,adjList,st,visited,pathvisited) == false )
                        return new int[0];
                    st.push(i);
                }
            }

            int[] courseOrder = new int[st.size()];
            int i=0;
            
            while(!st.isEmpty())
            {
                courseOrder[i++]=st.pop();
            }
            return courseOrder;
    }
}
