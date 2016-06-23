public class Solution {
    int jumps[][];
    int rst = 0;

    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;

        helper(0, m, n, 0, new HashSet<>());

        return rst;
    }

    private void helper(int curr, int m, int n, int length, Set<Integer> visited) {
        if (length >= m && length <= n) {
            rst++;
        }

        if (length == n) {
            return;
        }

        visited.add(curr);
        for (int i = 1; i <= 9; i++) {
            if (valid(curr, i, jumps, visited)) {
                helper(i, m, n, length + 1, visited);
            }
        }
        visited.remove(curr);
    }


    private boolean valid(int prev, int curr, int[][] jumps, Set<Integer> visited) {
        if (curr < 1 || curr > 9)
            return false;

        if (visited.contains(curr))
            return false;

        if (jumps[prev][curr] > 0 && !visited.contains(jumps[prev][curr]))
            return false;

        return true;
    }
}