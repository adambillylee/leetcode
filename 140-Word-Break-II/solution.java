public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<>();
        // sanity check
        if (s == null || wordDict == null || wordDict.size() == 0)
            return rst;

        List<List<StringBuilder>> dp = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++)
            dp.add(new ArrayList<>());

        dp.get(0).add(new StringBuilder());

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp.get(j).isEmpty()) {
                    String curr = s.substring(j, i);

                    if (wordDict.contains(curr)) {
                        for (StringBuilder prefix : dp.get(j)) {
                            StringBuilder tmp = new StringBuilder(prefix).append(" ").append(curr);
                            dp.get(i).add(tmp);

                            if (i == s.length())
                                rst.add(tmp.toString().trim());
                        }
                    }
                }
            }
        }

        return rst;
    }
}