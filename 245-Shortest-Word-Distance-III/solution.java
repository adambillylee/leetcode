public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;

        int last2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.equals(word1) && last2 != -1) {
                int currDis = Math.abs(i - last2);
                if (currDis > 0)
                    minDis = Math.min(currDis, minDis);
            }

            if (word.equals(word2)) {
                last2 = i;
            }
        }

        last2 = words.length;
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];

            if (word.equals(word1) && last2 != words.length) {
                int currDis = Math.abs(last2 - i);
                if (currDis > 0)
                    minDis = Math.min(currDis, minDis);
            }

            if (word.equals(word2)) {
                last2 = i;
            }

        }

        return minDis;
    }
}