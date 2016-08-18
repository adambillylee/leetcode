/**
 * Created by adamli on 8/17/16.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int i = 0;
        int j = 0;
        int targetMap[] = new int[128];
        int currMap[] = new int[128];
        String min = "";

        for (char c : t.toCharArray()) {
            targetMap[c - 'A']++;
        }

        while (j < s.length()) {
            while (j < s.length() && !covers(currMap, targetMap)) {
                currMap[s.charAt(j) - 'A']++;
                j++;

                if (covers(currMap, targetMap))
                    min = update(min, s, i, j);
            }

            while (i < j && covers(currMap, targetMap)) {
                if (covers(currMap, targetMap))
                    min = update(min, s, i, j-1);

                currMap[s.charAt(i) - 'A']--;
                i++;
            }
        }

        return min;
    }

    private String update(String min, String s, int i, int j) {
        if (j > s.length() - 1)
            j = s.length() - 1;

        if (j - i + 1 < min.length() || min.isEmpty()) {
            min = s.substring(i, j + 1);
        }

        return min;
    }

    private boolean covers(int currMap[], int targetMap[]) {
        for (int i = 0; i < currMap.length; i++) {
            if (targetMap[i] > currMap[i])
                return false;
        }

        return true;
    }
}
