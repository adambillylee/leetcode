public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int i = 0;
        int j = 0;
        int length = 0;
        Map<Character, Integer> count = new HashMap();

        while (j < s.length()) {
            while (count.size() <= 2 && j < s.length()) {
                char curr = s.charAt(j);

                updateMap(curr, count);

                if (count.size() <= 2) {
                    length = Math.max(length, j - i + 1);
//                    System.out.println("length :" + length);
                }

                j++;
            }

            while (count.size() > 2 && i <= j) {
                removeMap(s, i, count);

                i++;
            }
        }

        return length;
    }

    private void removeMap(String s, int i, Map<Character, Integer> count) {
        char c = s.charAt(i);

        int tmp = count.get(c) - 1;

        if (tmp > 0)
            count.put(c, tmp);
        else
            count.remove(c);

//        System.out.format("remove %c from map, map size = %d \n", c, count.size());
    }

    private void updateMap(char curr, Map<Character, Integer> count) {
        if (count.containsKey(curr)) {
            count.put(curr, count.get(curr) + 1);
        } else {
            count.put(curr, 1);
        }

//        System.out.format("add %c into map, map size = %d \n", curr, count.size());
    }    
}