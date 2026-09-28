class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // we have to return shortest path to the exit what is exit
        /**
        exit defined as 
        its is the edge node where 
        maze[i][j]=
        
         */
        // we start with the queue
        // if(maze.size()==2){
        //     return -1;
        // }
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { entrance[0], entrance[1], 0 });

        int count = 0;
        maze[entrance[0]][entrance[1]] = '+';
        while (!q.isEmpty()) {
            // now we will
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] val = q.poll();
                int row = val[0];
                int col = val[1];
                //
                boolean isBorder = (row == 0 || row == m - 1 || col == 0 || col == n - 1);
                boolean isNotEntrance = (row != entrance[0] || col != entrance[1]);
                if(isBorder && isNotEntrance){
                    return count;
                }
              // 2. Explore all 4 directions
        for (int[] d : dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            
            // 3. Check bounds and if it's an empty cell
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                // Add to queue
                q.offer(new int[]{newRow, newCol});
                // IMMEDIATELY mark as visited to prevent TLE
                maze[newRow][newCol] = '+'; 
            }
        }
            }
            count++;
        }
        return -1;
    }
}