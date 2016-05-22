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
        List<Interval> rst = new ArrayList<>();
        
        if (intervals.size() == 0) {
            rst.add(newInterval);
            return rst;
        }

        // before newInterval
        int curr = 0;
        while (intervals.get(curr).end < newInterval.start) {
            rst.add(intervals.get(curr));
            curr++;
        }

        // merge new intervel
        int start = newInterval.start;
        int end = newInterval.end;
        while (curr < intervals.size() && intervals.get(curr).start < newInterval.end) {
            start = Math.min(start, intervals.get(curr).start);
            end = Math.max(end, intervals.get(curr).end);
            curr++;
        }

        Interval tmp = new Interval(start, end);
        rst.add(tmp);

        // add the rest
        while (curr < intervals.size()) {
            rst.add(intervals.get(curr));
            curr++;
        }

        return rst;
    }
}