class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;

        int r=board.length;
        int c=board[0].length;

        for(int i=0;i<r;i++){
            dfs(board,i,0);
            dfs(board,i,c-1);
        }

        for(int j=0;j<c;j++){
            dfs(board,0,j);
            dfs(board,r-1,j);
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T') {
                    board[i][j]='O';
                }
            }
        }
    }

    public void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length|| board[i][j]!='O'){
            return;
        }

        board[i][j]='T';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}