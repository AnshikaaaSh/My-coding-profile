class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        boolean[] visited = new boolean[n]; // Array to track visited cities
        int provinceCount = 0; // Variable to store the count of provinces

        // Iterate over all cities
        for (int i = 0; i < n; i++) {
            // If the city is not visited, it belongs to a new province
            if (!visited[i]) {
                dfs(isConnected, visited, i); // Perform DFS to mark all cities in this province
                provinceCount++; // Increment province count
            }
        }
        
        return provinceCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true; // Mark the current city as visited
        
        for (int i = 0; i < isConnected.length; i++) {
            // If city `i` is connected to the current city and not visited yet
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i); // Recursively visit city `i`
            }
        }
    }
}