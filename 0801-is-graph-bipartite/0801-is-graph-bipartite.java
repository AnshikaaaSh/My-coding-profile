class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];  // Initialize all nodes as uncolored (0)
        
        // Iterate over all nodes in case the graph is disconnected
        for (int start = 0; start < n; start++) {
            if (colors[start] == 0) {  // If the node is uncolored
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(start);
                colors[start] = 1;  // Color the node with 1
                
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    
                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {  // If the neighbor is uncolored
                            colors[neighbor] = -colors[node];  // Assign opposite color
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            // If neighbor has the same color, graph is not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;  // If we successfully color the graph, it is bipartite
    }
}