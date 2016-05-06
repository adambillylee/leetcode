public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int max = 0;
        char[] charArray = s.toCharArray();

        // find longest palindrome substring in s starts at 0
        for (int end = 0; end < s.length(); end++) {
            if (isPalindrome(charArray, end)) {
                max = Math.max(max, end);
            }
        }

        // find the remaining
        String remains = s.substring(max + 1, s.length());
        StringBuilder sb = new StringBuilder();

        // reverse remaining
        for (int i = remains.length() - 1; i >= 0; i--)
            sb.append(remains.charAt(i));

        sb.append(s);

        return sb.toString();
    }

    private boolean isPalindrome(char charArray[], int end) {
        int l = 0;
        int r = end;

        while (l < r) {
            if (charArray[l] != charArray[r])
                return false;
            l++;
            r--;
        }

        return true;
    }
}