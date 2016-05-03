public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        
        int count=0;
        
        for (int one = 0; one<nums.length; one++) {
            int two = one + 1;
            int three = nums.length - 1;
            
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                
                if (sum < target) {
                    count += three - two;
                    two++;
                }else{
                    three--;
                }
            }
        }
        
        return count;
    }
}