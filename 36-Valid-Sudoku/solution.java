import java.util.Arrays;

/**
 * Created by adamli on 8/20/16.
 */
public class Solution {
    private boolean[][] horizontal = new boolean[9][9];
    private boolean[][] vertical = new boolean[9][9];
    private boolean[][] square = new boolean[9][9];
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int index = (i / 3) * 3 + (j / 3);
                int num = board[i][j] - '1';

                if (horizontal[i][num] || vertical[j][num] || square[index][num])
                    return false;

                horizontal[i][num] = vertical[j][num] = square[index][num] = true;
            }
        }

        return true;
    }
}