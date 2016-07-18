public class Solution {
    Stack<Integer> stack = new Stack();

    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int i = 0;
        int maxBotWater, max = 0;
        while (i < height.length) {
            int currHeight = height[i];

            if (stack.isEmpty() || height[stack.peek()] >= currHeight) {
                stack.push(i);
                i++;
            } else {
                int bot = stack.pop();
                maxBotWater = stack.isEmpty() ? 0
                        : ((Math.min(height[stack.peek()], height[i]) - height[bot]) * (i - stack.peek() - 1));
                max += maxBotWater;
            }
        }

        return max;
    }
}