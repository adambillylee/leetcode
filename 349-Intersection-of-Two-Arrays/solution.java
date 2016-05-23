public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums1) {
            numbers.add(num);
        }

        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (numbers.contains(num))
                intersect.add(num);
        }

        int[] rst = new int[intersect.size()];
        Iterator<Integer> iterator = intersect.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            rst[i++] = iterator.next();
        }

        return rst;
    }
}