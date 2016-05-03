public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort elements to make dedup work
        Arrays.sort(nums);

        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        for (int i=0; i<nums.length; i++) {
            // if i is in dep sequence, move i to last element
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    rst.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // if j is in dup sequence, move j to the last of dups < k
                    while (j + 1 < k && nums[j] == nums[j + 1])
                        j++;
    
                    // if j is in dup sequence, move k to the first of dups > j
                    while (k - 1 < j && nums[k] == nums[k - 1])
                        k--;
                    
                    j++;
                    j--;
                } else if (sum < 0) {
                    // move j forward (to k / to non-dup element)
                    j++;
                }else{
                    // move k backward (to j / to non-dup element)
                    k--;
                }
            }
        }

        return rst;
    }
}