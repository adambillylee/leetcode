public class Solution {
    Map<String, String> mapping = new HashMap<>();
    Set<String> mappedStr = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty())
            return str.isEmpty();

        for (int i = 1; i <= str.length(); i++) {
            String patternCut = pattern.substring(0, 1);
            String strCut = str.substring(0, i);

            if (mapping.containsKey(patternCut)) {
                if (mapping.get(patternCut).equals(strCut)) {
                    return wordPatternMatch(pattern.substring(1), str.substring(i));
                }else{
                    continue;
                }

            } else {
                if (mappedStr.contains(strCut))
                    continue;

                mappedStr.add(strCut);
                mapping.put(patternCut, strCut);
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }else {
                    mappedStr.remove(strCut);
                    mapping.remove(patternCut);
                }
            }

        }

        return false;
    }
}