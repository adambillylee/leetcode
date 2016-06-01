public class Solution {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        if (m == 0 || n == 0)
            return;

        int[][] rst = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = calculate(board, i, j);
            }
        }
    }

    private int calculate(int[][] board, int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (i >= m || j >= n)
            return 0;

        int curr = board[i][j];

        int neighbours = calculate(board, i + 1, j + 1) + calculate(board, i + 1, j) + calculate(board, i, j + 1) +
                calculate(board, i - 1, j - 1) + calculate(board, i - 1, j) + calculate(board, i, j - 1) +
                calculate(board, i + 1, j - 1) + calculate(board, i - 1, j + 1);

        if (curr == 1) {
            if (neighbours == 2 || neighbours == 3)
                return 1;
            else
                return 0;
        } else {
            if (neighbours == 3)
                return 1;
            else
                return 0;
        }
    }
}