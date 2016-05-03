public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                int rst[] = new int[2];
                rst[0] = left + 1;
                rst[1] = right + 1;
                return rst;
            }else if (sum>target){
                right--;
            }else{
                left++;
            }
        }
        
        return null;
    }
}