public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.size ==0)
            return;
            
        int j = 0;    
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = num[j];
        num[j] = tmp;
    }
}