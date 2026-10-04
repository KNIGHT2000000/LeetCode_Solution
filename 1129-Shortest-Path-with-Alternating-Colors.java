class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // we need to build adjcacency list

        //this is going to be last question from bfs pattern 
      // state representation --->currentnode,current ditance,previous color
      // a standard visisted array will fail as we can be visiting same node for differnt alternate combination

    
      int[] answer = new int[n];
        Arrays.fill(answer, -1);
      Queue<int[]> q=new LinkedList<>();
      // queue made 
      q.offer(new int[]{0, 0, 0});
        q.offer(new int[]{0, 0, 1});

        boolean[][] visited= new boolean[n][2];
        // this boolean keeps track of all the 
        visited[0][0]=true;
        visited[0][1]=true;
        // marked both 
        while(!q.isEmpty()){
            int[] current =q.poll();
            int node=current[0];
            int dist=current[1];
            int prev_state=current[2];
            // Record the shortest distance if it hasn't been set yet.
            // Because it's BFS, the first time we reach a node is guaranteed to be the shortest path.
            if (answer[node] == -1) {
                answer[node] = dist;
            }
            // now we will expand for all the neighbour
     if(prev_state!=0){
        for(int i=0;i<redEdges.length;i++){
            int src = redEdges[i][0];
            int dest = redEdges[i][1];
            if(src==node && !visited[dest][0]){
                visited[dest][0]=true;
                q.offer(new int[]{dest,dist+1,0});
            }
        }
     }
     else if(prev_state!=1){
        // previous state was not the one we needed 
        for(int j=0;j<blueEdges.length;j++){
            int src=blueEdges[j][0];
            int dest=blueEdges[j][1];
             if(src==node && !visited[dest][1]){
                visited[dest][1]=true;
                q.offer(new int[]{dest,dist+1,1});
            }

        }
     }



        }
return answer;
    }
}