public class Solution {
    public int[] countBits(int num) {
        int rst[] = new int[num + 1];
        rst[0] = 0;
        rst[1] = 1;

        int pow = 1;
        for (int i = 2; i < num; i++) {
            if (i == pow * 2) {
                pow *= 2;
            }

            rst[i] = rst[i - pow] + 1;
        }

        return rst;
    }
}