public class Solution {
    public List<String> generateAbbrevihttps://leetcode.com/discuss/questions/oj/generalized-abbreviationations(String word) {
        List<String> rst = new ArrayList<>();

        if (word == null || word.length() == 0)
            return rst;

        helper(rst, word, 0, 0, new StringBuilder());

        return rst;
    }

    private void helper(List<String> rst, String word, int index, int count, StringBuilder sb) {
        if (index == word.length()) {
            if (count > 0) {
                sb.append(count);
                rst.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            } else {
                rst.add(sb.toString());
            }
            return;
        }

        int len = sb.length();

        helper(rst, word, index + 1, count + 1, sb);

        if (count > 0) {
            helper(rst, word, index + 1, 0, sb.append(count).append(word.charAt(index)));
        } else {
            helper(rst, word, index + 1, 0, sb.append(word.charAt(index)));
        }

        sb.setLength(len);
    }
}