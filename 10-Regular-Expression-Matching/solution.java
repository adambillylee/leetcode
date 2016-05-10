public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int indS, int indP) {
        if (indP == p.length())
            return indS == s.length();

        // if (indP + 1 >= p.length()) {
        //     if (!matchFirst(s, p, indS, indP))
        //         return false;
        //     else
        //         return helper(s, p, indS+1, indP+1);
        // }

        if (indP + 1 >= p.length() || p.charAt(indP + 1) != '*') {
            if (!matchFirst(s, p, indS, indP))
                return false;
            else
                return helper(s, p, indS + 1, indP + 1);
        } else {
            int index = indS;
            for (; index < s.length() && matchFirst(s, p, index, indP); index++) {
                if (helper(s, p, index, indP + 2))
                    return true;

            }
            if (helper(s, p, index, indP+2)){
                return true;
            }
            return false;

//            if (helper(s, p, indS, indP + 2))
//                return true;
//
//            while (matchFirst(s, p, indS, indP)) {
//                if (helper(s, p, ++indS, indP + 2))
//                    return true;
//            }
//
//            return false;
        }
    }

    private boolean matchFirst(String s, String p, int indS, int indP) {
        if (indS >= s.length())
            return false;

        return (s.charAt(indS) == p.charAt(indP)) || (p.charAt(indP) == '.');
    }
}