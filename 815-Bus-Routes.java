class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 1. Edge Case: If we are already at the target
        if (source == target) return 0;
        
        // 2. Build your map (Your current map logic is perfectly fine!)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }
        
        // 3. Queue stores: [current_stop, buses_taken]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{source, 0});
        
        // 4. Visited arrays to prevent loops
        boolean[] visitedBuses = new boolean[routes.length];
        HashSet<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        
        // 5. Standard BFS
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stop = current[0];
            int buses = current[1];
            
            // If we reached the target stop, return the bus count
            if (stop == target) {
                return buses;
            }
            
            // Look up every bus that visits this stop
            // Use getOrDefault just in case a stop in the queue isn't in the map
            for (int bus : map.getOrDefault(stop, new ArrayList<>())) {
                // If we've already taken this bus, skip it
                if (visitedBuses[bus]) continue;
                
                visitedBuses[bus] = true;
                
                // Add all stops on this new bus route to our queue
                for (int nextStop : routes[bus]) {
                    if (!visitedStops.contains(nextStop)) {
                        visitedStops.add(nextStop);
                        q.offer(new int[]{nextStop, buses + 1});
                    }
                }
            }
        }
        
        // If the queue empties and we never found the target
        return -1;
    }
}