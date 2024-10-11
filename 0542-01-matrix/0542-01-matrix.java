class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0||mat[0].length==0) return new int[0][0];

        int m=mat.length, n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        int max=m*n;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) q.add(new int[]{i,j});
                else mat[i][j]=max;
            }
        }

        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] cell=q.poll();
            for(int[] d:dir){
                int r=cell[0]+d[0], c=cell[1]+d[1];
                if(r>=0 && r<m && c>=0 && c<n && mat[r][c]>mat[cell[0]][cell[1]]+1){
                    q.add(new int[]{r,c});
                    mat[r][c]=mat[cell[0]][cell[1]]+1;
                }
            }
        }
        return mat;
    }
}