public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0)
            return -1;
            
        if (needle.isEmpty())
            return 0;
        
        int j = 0;    
        for (int i=0; i<heystack.length(); i++) {
            while (i+needle.length() < heystack.length() && heystack.charAt(i+j) == needle.charAt(j)) {
                if (j >= needle.length())
                    continue;
                
                j++;
            }
            
            if (j == needle.length())
                return i;
        }
        
        return -1;
    }
}