public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList();
        
        if (word == null)
            return rst;
            
        helper(rst, word, 0, new StringBuilder(), false);
        return rst;
    }
    
    private void helper(List<String> rst, String word, int index, StringBuilder sb, boolean preNum) {
        if (index == word.length()) {
            rst.add(sb.toString());
            return;
        }
            
        int len = sb.length();
        
        for (int i=index; i<word.length(); i++) {
            if (i == index) {
                helper(rst, word, i+1, sb.append(word.charAt(i)), false);
                sb.setLength(len);
            }
            
            if (!preNum) {
                helper(rst, word, i+1, sb.append(getNumber(i, index)), true);
                sb.setLength(len);
            }
        }
    }
    
    private String getNumber(int i, int index) {
        return Integer.toString(i - index + 1);
    }
}