public class Solution {
    int depth = 1;

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> rst = new ArrayList<>();

        while (true) {
            helper(rst, beginWord, endWord, new ArrayList<String>(), new HashSet<String>(), wordList, 1);

            if (rst.size() > 0)
                return rst;
            else
                depth++;
        }
    }

    private void helper(List rst, String curr, String endWord, List<String> list, Set<String> visited, Set<String> wordList, int depth) {
        if (depth > this.depth) {
            if (curr.equals(endWord)) {
                list.add(curr);
                rst.add(new ArrayList(list));
                list.remove(list.size()-1);
            }

            return;
        }

        List<String> expended = expend(curr, endWord, visited, wordList);

        for (String ele : expended) {
            list.add(curr);
            visited.add(curr);
            helper(rst, ele, endWord, list, visited, wordList, depth + 1);
            list.remove(list.size() - 1);
            visited.remove(curr);
        }
    }

    private List<String> expend(String curr, String endWord, Set<String> visited, Set<String> wordList) {
        List<String> rst = new ArrayList<>();


        for (int i = 0; i < curr.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char charArray[] = curr.toCharArray();
                char replaceChar = (char) ('a' + j);

                if (replaceChar != charArray[i])
                    charArray[i] = replaceChar;
                else
                    continue;

                String replaced = String.valueOf(charArray);

                if (isValidExpendWord(endWord, visited, wordList, replaced))
                    rst.add(replaced);
            }
        }

        return rst;
    }

    private boolean isValidExpendWord(String endWord, Set<String> visited, Set<String> wordList, String replaced) {
        if (replaced.equals(endWord))
            return true;

        if (visited.contains(replaced))
            return false;

        if (!wordList.contains(replaced))
            return false;

        return true;
    }
}