//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    public boolean dfs(int i, int j, int n, int m, int[][] grid, boolean[][] vis) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nrow = drow[k] + i;
            int ncol = dcol[k] + j;
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && (grid[nrow][ncol] == 3 || grid[nrow][ncol] == 2) && !vis[nrow][ncol]) {
                // If the destination cell is found, return true
                if (grid[nrow][ncol] == 2 || dfs(nrow, ncol, n, m, grid, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    // Start DFS from the starting cell
                    if (dfs(i, j, n, m, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}