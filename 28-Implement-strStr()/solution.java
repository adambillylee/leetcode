public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0)
            return -1;
            
        if (needle.isEmpty())
            return 0;
        
        for (int i=0; i<haystack.length(); i++) {
            for (int j=0; j<= haystack.length() - needle.length(); j++) {
                if (i+j > haystack.length())
                    continue;
                
                if (haystack.charAt(i) != needle.charAt(j))
                    continue;
                    
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;
    }
}