public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return rst;

        int M = matrix.length;
        int N = matrix[0].length;

        int rs = 0;
        int re = M - 1;
        int cs = 0;
        int ce = N - 1;

        int count = 0;

        while (count < M * N) {
            // upper
            if (cs <= ce) {
                for (int i = cs; i <= ce; i++) {
                    // System.out.print(matrix[rs][i] + " ");
                    rst.add(matrix[rs][i]);
                    count++;
                }
                rs++;
            }
            
            if (rs > re)
                return rst;

            // right
            if (rs <= re) {
                for (int i = rs; i <= re; i++) {
                    // System.out.print(matrix[i][ce] + " ");
                    rst.add(matrix[i][ce]);
                    count++;
                }
                ce--;
            }
            
            if (cs > ce)
                return rst;

            // bottom
            if (cs <= ce) {
                for (int i = ce; i >= cs; i--) {
                    // System.out.print(matrix[re][i] + " ");
                    rst.add(matrix[re][i]);
                    count++;
                }
                re--;
            }
            
            if (rs > re)
                return rst;

            // left
            if (rs <= re) {
                for (int i = re; i >= rs; i--) {
                    // System.out.print(matrix[i][cs] + " ");
                    rst.add(matrix[i][cs]);
                    count++;
                }
                cs++;
            }
            
            if (cs > ce)
                return rst;
        }
        
        return rst;
    }
}