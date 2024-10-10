class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; // Count of fresh oranges
        
        // Step 1: Initialize the queue with all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j}); // Add rotten orange to the queue
                } else if (grid[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }
        
        // If no fresh oranges, return 0 (no time needed)
        if (freshCount == 0) return 0;

        // Step 2: BFS to rot adjacent fresh oranges
        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 4-directional moves

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false; // Track if any fresh oranges rot in this minute
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];
                
                // Check all 4-directionally adjacent cells
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the fresh orange
                        queue.offer(new int[] {newRow, newCol}); // Add to queue
                        freshCount--; // Decrease fresh orange count
                        hasRotten = true;
                    }
                }
            }
            if (hasRotten) minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}