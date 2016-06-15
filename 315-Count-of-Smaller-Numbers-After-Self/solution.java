public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums.length == 0 || nums == null)
            return rst;

        List<Integer> tmp = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int ind = findInsertPos(nums[i], tmp);
            tmp.add(ind, nums[i]);
            rst.add(0, ind);
        }

        return rst;
    }

    private int findInsertPos(int num, List<Integer> tmp) {
        int start = 0;
        int end = tmp.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (num > tmp.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}