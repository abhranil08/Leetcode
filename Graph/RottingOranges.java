class Node {
    int coord1,coord2,step;

    public Node( int coord1, int coord2, int step )
    {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.step = step;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int visited[][] = new int[rows][cols];
        Queue<Node> q = new LinkedList<>();
        int rotten = 0;

        for( int i = 0; i < rows; i++ )
        {
            for( int j = 0; j < cols; j++ )
            {
                if( grid[i][j] == 2 )
                {
                    q.add( new Node(i,j,0));
                    visited[i][j] = 1;
                }
                else if( grid[i][j] == 1 )
                    rotten++;
            }
        }

        int countFreshToRotten=0;
        int minStep=0;

        while( !q.isEmpty())
        {
            Node rottenOrange = q.peek();
            int coord1 = rottenOrange.coord1;
            int coord2 = rottenOrange.coord2;
            int step = rottenOrange.step;
            minStep = Math.max(step, minStep);
            q.remove();

            if(( coord1 - 1) >= 0 && grid[coord1 - 1][coord2] == 1 && visited[coord1 - 1][coord2] == 0 )
            {
                q.add( new Node(coord1 - 1, coord2, step+1));
                countFreshToRotten++;
                visited[coord1 - 1][coord2] = 1;
            }    
            if(( coord2 - 1) >= 0 && grid[coord1 ][coord2-1] == 1 && visited[coord1 ][coord2-1] == 0 )
            {
                q.add( new Node(coord1, coord2-1, step+1));
                countFreshToRotten++;
                visited[coord1 ][coord2-1] = 1;
            }    
            if(( coord1 + 1) < rows && grid[coord1 + 1][coord2] == 1 && visited[coord1 + 1][coord2] == 0)
            {
                q.add( new Node(coord1 + 1, coord2, step+1));
                countFreshToRotten++;
                visited[coord1 + 1][coord2] = 1;
            }    
            if(( coord2 + 1) < cols && grid[coord1 ][coord2+1] == 1 && visited[coord1 ][coord2+1] == 0)
            {
                q.add( new Node(coord1, coord2+1, step+1));
                countFreshToRotten++;
                visited[coord1 ][coord2+1] = 1;
            }    
        }
        if( rotten != countFreshToRotten)
            return -1;
        return minStep;

        
    }

}
