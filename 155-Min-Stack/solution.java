public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        
        if (min.isEmpty()) {
            min.push(x);
        }else{
            int head = min.peek();
            
            if (head > x) {
                min.push(x);
            }else{
                min.push(head);
            }
        }
    }
    
    public void pop() {
        min.pop();
        stack.pop();
    }
    
    public int top() {
        min.pop();
        return stack.pop();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */