public class Solution {
private List<String> result;

public List<String> fullJustify(String[] words, int maxWidth) {
    result = new ArrayList<String>();
    if (words == null || words.length == 0 || maxWidth < 0) return result;
    if (maxWidth == 0) {
        result.add("");
        return result;
    }
    helper(words, 0, maxWidth);
    return result;
}

public void helper(String[] words, int start, int L) {
    if (start >= words.length) return;
    
    int i = start, len = 0, total = 0, next = -1;
    while (total < L && i < words.length) {
        total += words[i].length();
        if (total > L) { // only in this case we need skip i++
            next = i;
            break;
        }
        len += words[i].length();
        total++; // count space
        i++;
    }
    
    if (next == -1) next = i;
    addList(words, start, next, len, L);
    
    helper(words, next, L);
}

public void addList(String[] words, int i, int j, int len, int L) {
    StringBuilder sb = new StringBuilder("");
    int count = j-i-1, space = 0, more = 0, s = 0;
    if (count == 0 || j == words.length) { // the last line
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            if (k == j-1) break;
            sb.append(" ");
        }
        space = L - sb.length();
        s = 0;
        while (s++ < space) sb.append(" ");
    } else {
        space = (L - len) / count; more = (L - len) % count;
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            s = 0;
            if (k == j-1) break;
            while (s++ < space) sb.append(" ");
            if (more-- > 0) sb.append(" ");
        }
    }
    
    result.add(sb.toString());
}
}