public class TicTacToe {
    int row[];
    int col[];
    int diag;
    int antiDiag;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        row = new int[n];
        col = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int n = this.row.length;
        int toAdd = player == 1 ? 1 : -1;

        this.row[row] += toAdd;
        if (Math.abs(this.row[row]) == n)
            return player;

        this.col[col]+= toAdd;
        if (Math.abs(this.col[col]) == n)
            return player;

        if (row == col) {
            this.diag+= toAdd;

            if (Math.abs(this.diag) == n)
                return player;
        }

        if (row + col == n - 1) {
            this.antiDiag+= toAdd;

            if (Math.abs(this.antiDiag) == n)
                return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */