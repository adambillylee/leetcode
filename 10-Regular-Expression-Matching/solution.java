public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int indS, int indP) {
        if (indP >= p.length())
            return indS == s.length();

        if (indP + 1 < p.length() && p.charAt(indP + 1) != '*') {
            if (p.charAt(indP) == s.charAt(indS)) {
                return helper(s, p, indS + 1, indP + 1);
            } else {
                return false;
            }
        } else {
            if (!match(s, p, indS, indP)) {
                return helper(s, p, indS, indP + 2);
            } else {
                int i = 0;
                while (shouldMatchNextCharInS(s, p, indS, indP, i)) {
                    boolean rst = helper(s, p, indS + i, indP + 2);

                    if (rst)
                        return true;

                    i++;
                }

                if (helper(s, p, indS + i, indP + 2))
                    return true;
                else
                    return false;
            }
        }
    }

    private boolean match(String s, String p, int indS, int indP) {
        if (indS < s.length() && p.charAt(indP) == s.charAt(indS))
            return true;

        if (p.charAt(indP) == '.')
            return true;

        return false;
    }

    private boolean shouldMatchNextCharInS(String s, String p, int indS, int indP, int i) {
        if (p.charAt(indP) == '.')
            return true;

        if (indS + i >= s.length())
            return false;

        if (s.charAt(indS + i) != p.charAt(indP))
            return false;

        return true;
    }
}