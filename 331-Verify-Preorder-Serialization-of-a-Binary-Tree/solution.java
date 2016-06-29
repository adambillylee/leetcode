public class Solution {
    public boolean isValidSerialization(String preorder) {
        // curr = out - in

        String list[] = preorder.split(",");

        int curr = 2 - 1;
        for (String s : list) {
            curr--;
            
            if (curr < 0)
                return false;
            
            if (s.equals("#")) {
                curr += 0;
            } else {
                curr += 2;
            }
        }

        return curr == 0;
    }
}