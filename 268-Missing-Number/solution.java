public class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for (int ele : input) {
            actualSum += ele;
        }

        int n = input.length + 1;
        int expectedSum = (1+n) * n / 2;

        return expectedSum - actualSum;
    }
}