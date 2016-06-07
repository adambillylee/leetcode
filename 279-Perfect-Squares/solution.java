public class Solution {
    public int numSquares(int n) {
        if (n < 1)
            return 0;

        // largest sqr which its square <= n
        int sqr[] = new int[n + 1];

        // min number of perfect square adds up to n
        int min[] = new int[n + 1];

        sqr[0] = 0;
        for (int i = 1; i <= n; i++) {
            int nextSq = (sqr[i - 1] + 1) * (sqr[i - 1] + 1);

            if (nextSq > i) {
                sqr[i] = sqr[i - 1];
                min[i] = i;

                for (int j = 1; j * j < i; j++) {
                    int tmp = min[i - j * j] + min[j * j];

                    if (tmp < min[i])
                        min[i] = tmp;
                }
            } else {
                sqr[i] = sqr[i - 1] + 1;
                min[i] = 1;
            }
        }

        return min[n];
    }
}