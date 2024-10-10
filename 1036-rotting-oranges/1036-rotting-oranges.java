class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []> q=new LinkedList<>();
        int fc=0;
        int min=0;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1) fc++;
            }
        }
        if(fc==0) return 0;

        while(!q.isEmpty()){
            int s=q.size();  
            boolean hasr=false;
            for(int i=0;i<s;i++){
                int[] curr=q.poll();
                int row=curr[0];
                int col=curr[1];
                for(int[] d:dir){
                    int newr=row+d[0];
                    int newc=col+d[1];
                    if(newr>=0 && newr<m && newc>=0 &&newc<n&& grid[newr][newc]==1){
                        grid[newr][newc]=2;
                        q.add(new int[]{newr,newc});
                        fc--;
                        hasr=true;
                    }
                }
            }
            if(hasr) min++;
        }
        return fc==0?min:-1;
    }
}