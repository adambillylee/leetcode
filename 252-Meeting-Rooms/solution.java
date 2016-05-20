/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0)
            return true;
            
        Comparator<Interval> comparator = new Comparator() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        }
        Collections.sort(intervals, comparator);
            
        int end = -1;
        for (Interval interval : intervals) {
            if (interval.start <= end)
                return false;
            else
                end = interval.end;
        }
        
        return true;
    }
}