class Solution {
    public void setZeroes(int[][] matrix) {
        //ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<>>();
        int n=matrix.length;
        int m=matrix[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         al.get(i).add(j);
        //     }
        // }
        int[] rows=new int[n];
        int[] col=new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rows[i]==1||col[j]==1){
                    matrix[i][j]=0;
                    //al.get(i).set(j,0);
                }
            }
        }
        //return matrix;
    }
}