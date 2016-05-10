/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        
        for (int i=1; i<n; i++) {
            if (knows(celebrity, i))
                celibrity = i;
        }
        
        int i=0;
        for (; i<n; i++) {
            if (i != celebrity && knows(i, celebrity) && !knows(celibrity, i))
                continue;
            else
                break;
        }
        
        if (i == n)
            return celebrity;
        else
            return -1;
    }
}