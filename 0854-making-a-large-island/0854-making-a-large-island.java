class Solution {
    int island_id;
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int dfs(int[][] grid, int r, int c) {
        int m = grid.length;

        if (0 <= r && r < m && 0 <= c && c < m && grid[r][c] == 1) {
            grid[r][c] = island_id;
            int a = 1;
            for (int[] d : dir) {
                int nR = r + d[0];
                int nC = c + d[1];
                a += dfs(grid, nR, nC);
            }
            return a;
        } else {
            return 0;
        }

    }

    public int largestIsland(int[][] grid) {
        // 1st pass to update ids using dfs helper, create a mapping of ids with areas
        island_id = -1;
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int area = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    area = dfs(grid, r, c);
                    map.put(island_id, area);
                    island_id--;
                }

            }
        }
        int max_area = Integer.MIN_VALUE;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int a = 1;
                    for (int[] d : dir) {
                        int nR = r + d[0];
                        int nC = c + d[1];

                        if (0 <= nR && nR < m && 0 <= nC && nC < n && grid[nR][nC] != 0) {
                            seen.add(grid[nR][nC]);
                        }
                    }

                    for (int id : seen) {
                        a += map.get(id);
                    }
                    max_area = Math.max(max_area, a);

                }
            }
        }
        return max_area == Integer.MIN_VALUE ? m * n : max_area;
    }
}