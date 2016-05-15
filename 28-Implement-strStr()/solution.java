public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        
        if (haystack.isEmpty())
            return -1;
        
        for (int i=0; i<haystack.length(); i++) {
            int j = 0; 
            
            /**
             * three conditions for inner loop:
             * 1. i + needle.length <= haystack.length() -> haystack is long enough
             * 2. j < needle.length -> needle is long enough
             * 3. haystack.charAt(i+j) == needle.charAt(j) char is equal
             */
            while (i+needle.length() <= haystack.length() && j< needle.length() 
                && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            
            if (j == needle.length())
                return i;
        }
        
        return -1;
    }
}