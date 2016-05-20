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
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);

        int i = 0;
        while (i < intervals.size()) {
            if (i == intervals.size() - 1) {
                rst.add(intervals.get(i));
                break;
            }

            int j = i + 1;
            Interval tmp = intervals.get(i);
            while (j < intervals.size() && overlap(tmp, intervals.get(j))) {
                tmp = merge(tmp, intervals.get(j));
                j++;
            }

            rst.add(tmp);
            i = j;
        }

        return rst;
    }

    private Interval merge(Interval tmp, Interval prev) {
        return new Interval(Math.min(tmp.start, prev.start), Math.max(tmp.end, prev.end));
    }

    private boolean overlap(Interval prev, Interval tmp) {
        return prev.end >= tmp.start;
    }
}