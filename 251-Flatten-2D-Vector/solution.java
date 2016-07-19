public class Vector2D implements Iterator<Integer> {
    Deque<List<Integer>> stack = new ArrayDeque<>();
    int index;
    List<List<Integer>> vec2d;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.index = 0;
    }

    @Override
    public Integer next() {
        int rst = stack.pop().get(0);
        return rst;
    }

    @Override
    public boolean hasNext() {
        clearStack();
        
        if (stack.isEmpty() && index == vec2d.size()) {
            return false;
        }else if (!stack.isEmpty()){
            return true;
        }else{
            stack.push(vec2d.get(index++));
            return hasNext();
        }
    }
    
    public void clearStack() {
        while(!stack.isEmpty() && stack.peek().size() != 1) {
            List<Integer> tmp = stack.pop();
            
            if (tmp.isEmpty())
                continue;
            
            for (int i=tmp.size()-1; i>=0; i--) {
                List<Integer> newList = new ArrayList();
                newList.add(tmp.get(i));
                stack.push(newList);
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */