class Solution {
    public int maxDistance(int[][] grid) {
        // given a 2d array and we have to find an cell where val=0 and the distance from all the nearest land is maximised 
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    q.offer(new int[] { r, c });
                }
            }
        }
        if (q.isEmpty() || q.size() == n * m) {
            return -1;
        }

        // now we have all the sources in the queue

        int maxdistance = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                for (int[] dir : dirs) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==0){
                        grid[r][c]=1;//marked visited
                        q.offer(new int[]{r,c});
                    }
                }
            }
            maxdistance++;
        }
return maxdistance-1;
    }
}