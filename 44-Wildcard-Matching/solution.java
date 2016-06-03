public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        int i = 0;
        int j = 0;
        int startP = -1;
        int startS = -1;
        int dist = -1;

        while (j < s.length()) {
            if (i < p.length() && p.charAt(i) == '*') {
                startP = i;
                startS = j;
                dist = 0;
                i++;
            } else if (i < p.length() && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')) {
                i++;
                j++;
            } else {
                if (dist == -1) {
                    return false;
                } else {
                    dist++;
                    i = startP + 1;
                    j = startS + dist;
                }
            }
        }

        while (i < p.length() && p.charAt(i) == '*')
            i++;

        return i == p.length() && j == s.length();
    }
}