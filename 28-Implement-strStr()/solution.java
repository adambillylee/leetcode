public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0)
            return -1;
            
        if (needle.isEmpty())
            return 0;
        
        for (int i=0; i<heystack.length(); i++) {
            for (int j=0; j<needle.length(); j++) {
                if (i+j > heystack.length())
                    continue;
                
                if (heystack.charAt(i) != needle.charAt(j))
                    continue;
                    
                if (j == needle.charAt(j))
                    return i;
            }
        }
        
        return -1;
    }
}