public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int result[] = new int[2];
        
        for (int i=0; i<nums.length; i++) {
            int n = nums[i];
            
            // if target - n is in map, construct result aray
            if (map.containsKey(target - n)) {
                result[0] = map.get(target - n);
                result[1] = i;
                return result;
            }else{
                // if target - n is not in map, put n as key and index as value
                // do not get confused and put target - n into map
                map.put(n, i);
            }
        }
        
        return result;
    }
}