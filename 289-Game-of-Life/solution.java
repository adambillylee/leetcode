public class Solution {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        if (m == 0 || n == 0)
            return;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = calculate(board, i, j);
//                System.out.print(board[i][j] + " ");
            }
//            System.out.println();
        }

//        System.out.println();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int calculate(int[][] board, int i, int j) {
        int total = 0;

        total = addValue(board, i - 1, j - 1) + addValue(board, i - 1, j) + addValue(board, i, j - 1)
                + addValue(board, i + 1, j + 1) + +addValue(board, i, j + 1) + addValue(board, i + 1, j)
                + addValue(board, i + 1, j - 1) + addValue(board, i - 1, j + 1);

        if ((board[i][j] & 1) == 0) {
            if (total == 3)
                return 2;
            else
                return 0;
        } else {
            if (total < 2 || total > 3)
                return 1;
            else
                return 3;
        }
    }

    private int addValue(int[][] board, int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (i >= m || j >= n)
            return 0;

        return board[i][j] & 1;
    }
}