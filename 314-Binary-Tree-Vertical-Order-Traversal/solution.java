/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        
        if (root == null)
            return rst;
        
        int minCol = 0;
        int maxCol = 0;

        Map<Integer, List<Integer>> map = new HashMap();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Queue<Pair> next = new LinkedList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pair curr = queue.poll();
                int col = curr.col;
                TreeNode node = curr.node;

                if (!map.containsKey(col)) {
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);
                    map.put(col, new ArrayList<>());
                }

                map.get(col).add(node.val);
//                System.out.println("col: " + col + " val: " + node.val);

                if (node.left != null)
                    next.offer(new Pair(node.left, col - 1));
                if (node.right != null)
                    next.offer(new Pair(node.right, col + 1));

            }
            queue = next;
        }

        for (int col = minCol; col <= maxCol; col++) {
            rst.add(map.get(col));
        }

        return rst;
    }
}