public class Solution {
    public boolean isUgly(int num) {
        if (num < 1)
            return false;

        int factors[] = {2,3,5};

        for (int factor : factors) {
            while (num % factor == 0) {
                num = num / factor;
            }
        }

        return num == 1;
    }
}