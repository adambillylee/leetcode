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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();

        if (intervals.size() <= 1)
            return intervals;

        // sort all intervals by start time first
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else{
                rst.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        rst.add(new Interval(start, end));
        return rst;
    }
}