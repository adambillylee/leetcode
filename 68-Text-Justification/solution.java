public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0) {
            return result;
        }
         
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
         
        fullJustifyHelper(0, words, result, maxWidth);
         
        return result;
    }
     
    private void fullJustifyHelper(int start, String[] words, 
                  List<String> result, int L) {
        if (start >= words.length) {
            return;
        }
         
        int total = 0;
        int len = 0;
        int next = -1;
        int i = start;
         
        while (i < words.length && total < L) {
            total += words[i].length();
             
            if (total > L) {
                next = i;
                break;
            }
             
            len += words[i].length();
            total++;
            i++;
        }
         
        if (next == -1) {
            next = i;
        }
         
        addLists(words, start, next, result, len, L);
         
        fullJustifyHelper(next, words, result, L);
    }
     
    private void addLists(String[] words, int start, int next, 
                          List<String> result, int len, int L) {
        int slots = next - start - 1;
        StringBuffer sb = new StringBuffer();
        // Last line or only one word in a line
        if (slots == 0 || next == words.length) {
            for (int i = start; i < next; i++) {
                sb.append(words[i]);
                if (i == next - 1) {
                    break;
                }
                sb.append(" ");
            }
             
            int trailingSpace = L - len - slots;
            for (int i = 0; i < trailingSpace; i++) {
                sb.append(" ");
            }
             
            result.add(sb.toString());
        } else {
            int aveSpace = (L - len) / slots;
            int moreSpace = (L - len) % slots;
            for (int i = start; i < next; i++) {
                sb.append(words[i]);
                if (i == next - 1) {
                    break;
                }
                for (int j = 0; j < aveSpace; j++) {
                    sb.append(" ");
                }
                 
                if (moreSpace > 0) {
                    sb.append(" ");
                    moreSpace--;
                }
            }   
            result.add(sb.toString());
        }
    }
}