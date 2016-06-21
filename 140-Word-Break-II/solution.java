public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<>();
        // sanity check
        if (s == null || wordDict == null || wordDict.size() == 0)
            return rst;

        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++)
            dp.add(new ArrayList<>());

        dp.get(0).add("");

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp.get(j).isEmpty()) {
                    String curr = s.substring(j, i);

                    if (wordDict.contains(curr)) {
                        for (String prefix : dp.get(j)) {
                            String tmp = prefix + " " + curr;
                            dp.get(i).add(tmp.trim());
                        }
                    }
                }
            }
        }

        return dp.get(s.length());
    }
}