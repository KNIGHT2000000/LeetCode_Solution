// class Solution {
//     // Helper array for moving in 4 directions (up, right, down, left)
//     int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

//     public  void return_modifed_grid(int[][] grid,Queue<int[]> q)
//     {
     
//         int[] curr=new int[2];
//         boolean found = false;
//         for(int i=0;i<grid.length;i++){
//             if(found) break;
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j]==1){
//                   q.offer(new int[]{i,j});
//                   grid[i][j]=2;
//                   while(!q.isEmpty()){
//                     int[] curr1=q.poll();
//                     for(int[] dir : dirs){
//                         int r=curr[0]+dir[0];
//                         int c=curr[1]+dir[1];
//                         if(r<grid.length && r>=0 && c>=0 && c< grid.length && grid[i][j]=1){
//                             grid[r][c] = 2;
//                             q.offer(new int[]{r,c});
//                         }
//                     }
//                   }
//                    found=true;
//                    break;
//                 }

//             }

//         }

       

        
//     }

//     public int shortestBridge(int[][] grid) {
//         // how to build intutuion 
//         //here we have to understand '
//         //
//         Queue<int[]> q1 = new LinkedList<>();
// return_modifed_grid(grid,q1);

//         // we need to start a dfs  from one of the one from starting and mark all the 1 belong ing to the first island 3 and add all these  into the queue
//         // we will start multisoirce bfs now
//         int n=grid.length;
//       int distance=0;
//       while(!q1.isEmpty()){
//         int size=q1.size();
//         for(int i=0;i<size;i++){
//             //
//             int[] current=q1.poll();
//             if(grid[current[0]][current[1]]==1){
//                 return distance;
//             }
//             for(int[] dir : dirs){
//                 int r=current[0]+dir[0];
//                 int c=current[1]+dir[1];

//                 if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==0){
//                     grid[r][c]=2;
//                     q.offer(new int[]{r,c});

//                 }
//             }
//         }
//         distance++;
//       }
// return 0;
//     }
// }
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Helper array for moving in 4 directions (up, right, down, left)
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public void return_modifed_grid(int[][] grid, Queue<int[]> q) {
        boolean found = false;
        int n = grid.length;
        
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Local queue just for traversing and marking the first island
                    Queue<int[]> localQ = new LinkedList<>();
                    
                    localQ.offer(new int[]{i, j});
                    q.offer(new int[]{i, j}); // Also add to our main multi-source BFS queue
                    grid[i][j] = 2;
                    
                    while (!localQ.isEmpty()) {
                        int[] curr = localQ.poll();
                        
                        for (int[] dir : dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            
                            if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1) {
                                grid[r][c] = 2;
                                localQ.offer(new int[]{r, c});
                                q.offer(new int[]{r, c}); // Keep adding to our main queue
                            }
                        }
                    }
                    found = true;
                    break; // Break inner loop once the first island is fully processed
                }
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        Queue<int[]> q1 = new LinkedList<>();
        return_modifed_grid(grid, q1); // After this, q1 has all the coordinates of Island 1

        int n = grid.length;
        int distance = 0;
        
        // Multi-source BFS to find Island 2
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                int[] current = q1.poll();
                
                for (int[] dir : dirs) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];

                    if (r >= 0 && r < n && c >= 0 && c < n) {
                        // If we hit a 1, we found the second island!
                        if (grid[r][c] == 1) {
                            return distance;
                        }
                        // If we hit water (0), convert it to 2 to mark as visited and add to queue
                        if (grid[r][c] == 0) {
                            grid[r][c] = 2; 
                            q1.offer(new int[]{r, c}); 
                        }
                    }
                }
            }
            // Increment distance after checking the whole perimeter (one full level)
            distance++;
        }
        return 0;
    }
}