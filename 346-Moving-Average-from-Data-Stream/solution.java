public class MovingAverage {
    int sum;
    List<Integer> candidate;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sum = 0;
        candidate = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if (candidate.size() == size) {
            int first = candidate.get(0);
            candidate.removeFirst();
            sum -= first;
        }
        
        candidate.add(val);
        
        return (double)sum / candidate.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */