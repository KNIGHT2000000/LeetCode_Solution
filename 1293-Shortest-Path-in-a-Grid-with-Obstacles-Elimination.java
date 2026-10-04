// class Solution {
//     public int shortestPath(int[][] grid, int k) {
        
//         //here we need to keep tcak of obstacles removed and state of it as well as bfs has to be done
//         //
//     int m = grid.length;
//         int n = grid[0].length;

//     }
// }
class Solution {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        boolean[][][] visited =
            new boolean[m][n][k + 1];

        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int distance = 0;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int remaining = cur[2];

                if (r == m - 1 && c == n - 1)
                    return distance;

                for (int[] d : dirs) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n)
                        continue;

                    int newRemaining = remaining;

                    if (grid[nr][nc] == 1) {
                        newRemaining--;
                    }

                    if (newRemaining < 0)
                        continue;

                    if (!visited[nr][nc][newRemaining]) {

                        visited[nr][nc][newRemaining] = true;

                        q.offer(
                            new int[]{
                                nr,
                                nc,
                                newRemaining
                            }
                        );
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}