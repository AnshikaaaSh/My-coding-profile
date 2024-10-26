class Solution {
    public String tictactoe(int[][] moves) {
       int[] row = new int[3];
        int[] col = new int[3];
        int dia = 0;
        int antiDia = 0;

        //A: +1, B: -1
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];

            if (i % 2 == 0) {
                row[r]++;
                col[c]++;
                if (r == c) dia++;
                if (r + c == 2) antiDia++;

                if (row[r] == 3 || col[c] == 3 || dia == 3 || antiDia == 3) {
                    return "A";
                }
            } else {
                row[r]--;
                col[c]--;
                if (r == c) dia--;
                if (r + c == 2) antiDia--;

                if (row[r] == -3 || col[c] == -3 || dia == -3 || antiDia == -3) {
                    return "B";
                }
            }
        }

        return moves.length == 9 ? "Draw" : "Pending"; 
    }
}