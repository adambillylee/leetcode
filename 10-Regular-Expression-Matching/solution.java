public class Solution {
    class Pair {
        int indS;
        int indP;

        Pair (int indS, int indP) {
            this.indS = indS;
            this.indP = indP;
        }
    }

    public boolean isMatch(String s, String p) {
        Map<Pair, Boolean> map = new HashMap<>();

        return helper(p, s, map);
    }

    private boolean helper(String p, String s, Map<Pair, Boolean> map) {
        Pair curr = new Pair(s.length(), p.length());

        if (map.containsKey(curr))
            return map.get(curr);

        if (p.isEmpty() && s.isEmpty()) {
            map.put(curr, true);
            return true;
        }

        if (p.length() == 2 && p.charAt(1) == '*' && s.isEmpty()) {
            map.put(curr, true);
            return true;
        }

        if (p.isEmpty()) {
            map.put(curr, false);
            return false;
        }

        if (s.isEmpty()) {
            map.put(curr, false);
            return false;
        }

        boolean rst = false;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            String pHead = p.substring(0,1);
            String remaining = p.substring(2);

            if (helper(remaining, s, map))
                rst = true;
            else {
                while (!s.isEmpty() && (s.startsWith(pHead) || p.charAt(0) == '.')) {
                    rst = helper(remaining, s.substring(1), map);

                    if (rst)
                        break;

                    s = s.substring(1);
                }
            }
        } else {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                rst = helper(p.substring(1), s.substring(1), map);
            else
                rst = false;
        }

        map.put(curr, rst);
        return rst;
    }
}
