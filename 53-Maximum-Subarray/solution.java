public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length==0)
            return -1;
            
        int max = nums[0];
        int prev = max;
        int curr = max;
        int start = 0;
        int end = 0;
        
        for (int i=1; i<nums.length; i++) {
            int currStart = start;
            int currEnd = end;
            
            if (prev < 0) {
                curr = nums[i];
                currStart = i;
            }else{
                curr = nums[i] + prev;
            }
            
            prev = curr;
            currEnd = i;
            
            if (curr > max) {
                max = curr;
                start = currStart;
                end = currEnd;
            }
        }
        
        return max;
    }
}