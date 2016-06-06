public class Solution {
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for (int ele : nums) {
            actualSum += ele;
        }

        int n = nums.length;
        int expectedSum = (1+n) * n / 2;

        return expectedSum - actualSum;
    }
}