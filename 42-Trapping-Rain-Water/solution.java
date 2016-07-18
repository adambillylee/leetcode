public class Solution {
Stack<Integer> stack = new Stack();
    int total = 0;

    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int i = 0;
        while (i < height.length) {
            clearStack(i, height);

            stack.push(i++);
        }

        return total;
    }

    private void clearStack(int rightInd, int[] height) {
        while (!stack.isEmpty() && height[stack.peek()] < height[rightInd]) {
            int bot = height[stack.pop()];

            if (stack.isEmpty())
                break;

            int leftInd = stack.peek();

            int depth = Math.min(height[leftInd], height[rightInd]) - bot;
            int width = rightInd - leftInd - 1;

            total += depth * width;
        }
    }
}