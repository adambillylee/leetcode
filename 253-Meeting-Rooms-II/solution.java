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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;
            
        int counter = 1;
        
        // sort all intervals by start time first
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        
        int end = intervals[0].end;
        for (int i=1; i<intervals.length; i++) {
            Interval interval = intervals[i];
            
            if (interval.start < end) {
                counter++;
            }else{
                end = Math.max(end, interval.end);
            }
        }
        
        return counter;
    }
}