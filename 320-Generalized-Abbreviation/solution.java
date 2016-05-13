public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();

        if (word.length() == 0) {
            rst.add("");
            return rst;
        }

        helper(rst, word, 0, 0, "");

        return rst;
    }

    private void helper(List<String> rst, String word, int index, int count, String curr) {
        if (index == word.length()) {
            if (count > 0) {
                rst.add(curr + count);
            } else {
                rst.add(curr);
            }
            return;
        }

        helper(rst, word, index + 1, count + 1, curr);

        if (count > 0) {
            helper(rst, word, index + 1, 0, curr + count + word.charAt(index));
        } else {
            helper(rst, word, index + 1, 0, curr + word.charAt(index));
        }

    }
}