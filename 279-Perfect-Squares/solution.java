/**
 * Created by adamli on 6/21/16.
 */
public class Solution {
    public int numSquares(int n) {
        if (n <= 0)
            return n;

        int sqr = 1;

        int numSquare[] = new int[n + 1];
        numSquare[0] = 0;
        numSquare[1] = 1;

        for (int i = 1; i <= n; i++) {
            if ((sqr + 1) * (sqr + 1) == i) {
                numSquare[i] = 1;
                sqr++;
            } else {
                numSquare[i] = i;
                for (int j = sqr; j >= 1; j--) {
                    numSquare[i] = Math.min(numSquare[i], 1 + numSquare[i - j * j]);
                }
            }
        }

        return numSquare[n];
    }
}