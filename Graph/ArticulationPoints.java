/* Question
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.
 

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 

Constraints:
1 ≤ V ≤ 105

Link - https://www.geeksforgeeks.org/problems/articulation-point-1/1
*/

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends
class Solution
{
    int timer=0;
    private void dfs(int vertex, int parent, boolean visited[], 
        int low[], int[] disc, boolean[] isAP, ArrayList<ArrayList<Integer>> adj){
            visited[vertex]=true;
            low[vertex]=disc[vertex]=timer;
            timer++;
            
            ArrayList<Integer> neighbours = adj.get(vertex);
            int children=0;
            for(Integer neighbour : neighbours){
                if(!visited[neighbour]){
                    children++;
                    dfs(neighbour,vertex,visited,low,disc,isAP,adj);
                    low[vertex] = Math.min(low[vertex],low[neighbour]);
                    
                    if(low[neighbour]>=disc[vertex] && parent!=-1)
                    {
                        isAP[vertex]=true;
                    }
                    
                }
                else{
                    low[vertex] = Math.min(low[vertex], disc[neighbour]);
                }
                
            }
            
            if(parent==-1 && children>1)
                isAP[vertex]=true;
            
    }
    //Function to return Depth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int low[] = new int[V];
        int disc[] = new int[V];
        
        boolean visited[] = new boolean[V];
        boolean isAP[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, -1, visited, low, disc, isAP, adj);
            }
        }
        
        ArrayList<Integer> points = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(isAP[i])
                points.add(i);
        }
        
        if(points.size()==0){
            points.add(-1);
            return points;
        }
        return points;
    }
}

