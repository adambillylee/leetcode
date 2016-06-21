public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(p, s);
    }

    private boolean helper(String p, String s) {

        if (p.isEmpty() && s.isEmpty()) {
            return true;
        }

        if (p.length() >= 2 && p.charAt(1) == '*' && s.isEmpty()) {
            return helper(p.substring(2), s);
        }

        if (p.isEmpty()) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        boolean rst = false;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            String remaining = p.substring(2);

            if (helper(remaining, s))
                rst = true;
            else {
                while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    rst = helper(remaining, s.substring(1));

                    if (rst)
                        break;

                    s = s.substring(1);
                }
            }
        } else {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                rst = helper(p.substring(1), s.substring(1));
            else
                rst = false;
        }

        return rst;
    }
}
