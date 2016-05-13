public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<>();

        if (word.length() == 0) {
            rst.add("");
            return rst;
        }

        helper(rst, word, 0, new StringBuilder(), false);

        return rst;
    }

    private void helper(List<String> rst, String word, int index, StringBuilder sb, boolean prevNum) {
        if (index == word.length()) {
            rst.add(sb.toString());
            return;
        }

        int len = sb.length();

        /**
         * loop from current index to end of word
         */
        for (int i = index; i < word.length(); i++) {
            if (i == index) {
                helper(rst, word, i + 1, sb.append(word.charAt(i)), false);
                sb.setLength(len);
            }

            if (!prevNum) {
                helper(rst, word, i + 1, sb.append(getNumberString(index, i)), true);
                sb.setLength(len);
            }
        }
    }

    private String getNumberString(int start, int end) {
        // if start == end, the number is 1
        return Integer.toString(end - start + 1);
    }
}