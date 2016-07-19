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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList();
        int i = 0;
        // before merge
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            rst.add(intervals.get(i));
            i++;
        }
        
        // during merge
        Interval merged = newInterval;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            merged.start = Math.min(intervals.get(i).start, merged.start);
            merged.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        rst.add(merged);
        
        // after merger
        while (i < intervals.size()) {
            rst.add(intervals.get(i));
            i++;
        }
        
        return rst;
    }
}