class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean[] vis=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                c++;
            }
        }
        return c;
    }
    private void dfs(int[][] nc, boolean[] vis,int city){
        vis[city]=true;
        for(int i=0;i<nc.length;i++){
            if(nc[city][i]==1 && !vis[i]){
                dfs(nc,vis,i);
            }
        }
    }
}