public class Solution {
    public boolean isAnagram(String s, String t) {
        int i=0; 
        int j = s.length()-1;
        
        while (i<=j)  {
            if (s.charAt(i) == t.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}