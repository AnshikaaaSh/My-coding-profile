class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid.length==0) return 0;

        int r=grid.length;
        int c=grid[0].length;

        for(int i=0;i<r;i++){
            dfs(grid,i,0);
            dfs(grid,i,c-1);
        }
        for(int i=0;i<c;i++){
            dfs(grid,0,i);
            dfs(grid,r-1,i);
        }

        int cc=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1) cc++;
            }
        }
        return cc;
    }

    public void dfs(int[][] grid, int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1) return;
        grid[i][j]=2;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}