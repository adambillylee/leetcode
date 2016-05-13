public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList();
        
        if (nums.length == 0)
            return rst;
            
        helper(rst, new ArrayList<Integer>(), nums, 0);
        
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            rst.add(new ArrayList(list));
            return;
        }
        
        for (int i=index; i<nums.length; i++) {
            // add current element
            list.add(nums[i]);
            helper(rst, list, nums, index+1);
            list.remove(list.size()-1);
            
            // not add current element
            helper(rst, list, nums, index+1);
        }
    }
}