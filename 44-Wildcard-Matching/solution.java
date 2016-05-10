public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
    public boolean helper(String s, String p, int indS, int indP) {
        if (indP == p.length())
            return indS == s.length();
            
        if (p.charAt(indP) != '*') {
            if (!match(s, p, indS, indP)) {
                return false;
            }else{
                return helper(s, p, indS+1, indP+1);
            }
        }else{
            if (helper(s, p, indS, indP+1))
                return true;
                
            while (match(s, p, indS, indP)) {
                if (helper(s, p, ++indS, indP+1))
                    return true;
            }
            
            return false;
        }
    }
    
    private boolean match(String s, String p, int indS, int indP) {
        if (indS >= s.length())
            return false;
        
        if (p.charAt(indP) == s.charAt(indS))
            return true;
            
        if (p.charAt(indP) == '?')
            return true;
            
        if (p.charAt(indP) == '*')
            return true;
            
        return false;
    }
}