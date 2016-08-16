public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];

        int rst[][] = new int[n][n];
        int cs = 0;
        int ce = n - 1;
        int rs = 0;
        int re = n - 1;
        int count = 1;

        while (true) {
            // top
            for (int i = cs; i <= ce; i++) {
                rst[rs][i] = count++;
            }
            rs++;

            if (rs > ce)
                return rst;

            // right
            for (int i = rs; i <= re; i++) {
                rst[i][ce] = count++;
            }
            ce--;

            if (cs > ce)
                return rst;

            // bottom
            for (int i = ce; i >= cs; i--) {
                rst[re][i] = count++;
            }
            re--;

            if (rs > re)
                return rst;

            // left
            for (int i = re; i >= rs; i--) {
                rst[i][cs] = count++;
            }
            cs++;

            if (cs > ce)
                return rst;
        }
    }
}