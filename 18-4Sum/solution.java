public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        Arrays.sort(nums);

        for (int one = 0; one < nums.length; one++) {
            if (one - 1 >= 0 && nums[one] == nums[one - 1])
                continue;

            for (int two = one + 1; two < nums.length; two++) {
                if (two - 1 > one && nums[two] == nums[two - 1])
                    continue;

                int three = two + 1;
                int four = nums.length - 1;

                while(three < four) {
                    int sum = nums[one] + nums[two] + nums[three] + nums[four];

                    if (sum == target) {
                        rst.add(Arrays.asList(nums[one], nums[two], nums[three], nums[four]));

                        while (three < four && nums[three] == nums[three+1])
                            three++;

                        while (four > three && nums[four] == nums[four-1])
                            four--;

                        three++;
                        four--;
                    }else if(sum < target) {
                        three++;
                    }else{
                        four--;
                    }
                }
            }
        }

        return rst;
    }
}