public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int indS, int indP) {
        if (indP >= p.length() - 1)
            return indS == s.length() - 1;

        if (indP + 1 < p.length() && p.charAt(indP + 1) != '*') {
            if (p.charAt(indP) == s.charAt(indS)) {
                return helper(s, p, indS + 1, indP + 1);
            } else {
                return false;
            }
        } else {
            if (p.charAt(indP) != s.charAt(indS) && p.charAt(indP) != '.') {
                return helper(s, p, indS, indP + 2);
            } else {
                int i = 1;
                while (shouldContinueMatching(s, p, indS, indP, i)) {
                    boolean rst = helper(s, p, indS + i, indP + 2);

                    if (rst)
                        return true;
                }

                if (helper(s, p, indS + i, indP + 2))
                    return true;
                else
                    return false;
            }
        }
    }

    private boolean shouldContinueMatching(String s, String p, int indS, int indP, int i) {
        if (indS + i > s.length())
            return false;

        if (p.charAt(indP) == '.')
            return true;

        if (p.charAt(indP) != s.charAt(indS + i))
            return false;

        return true;
    }
}