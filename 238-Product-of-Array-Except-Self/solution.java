public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;

        int rst[] = new int[nums.length];

        rst[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            rst[i] = rst[i - 1] * nums[i - 1];
        }

        int prod = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rst[i] *= prod;
            prod *= nums[i];
        }

        return rst;
    }
}