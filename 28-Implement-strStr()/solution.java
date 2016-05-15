public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        
        if (haystack.isEmpty() == 0)
            return -1;
        
        int j = 0;    
        for (int i=0; i<haystack.length(); i++) {
            while (i+needle.length() < haystack.length() && j< needle.length() 
                && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            
            if (j == needle.length())
                return i;
        }
        
        return -1;
    }
}