class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length, m=grid[0].length, ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    solve(i,j,grid);
                }
            }
        }
        return ans;
    }
    public void solve(int r,int c,char[][] grid){
        int n=grid.length, m=grid[0].length, ans=0;
        if(r<0||r>=n||c<0||c>=m||grid[r][c]=='0') return;

        grid[r][c]='0';
        solve(r+1,c,grid);
        solve(r-1,c,grid);
        solve(r,c+1,grid);
        solve(r,c-1,grid);
    }
}