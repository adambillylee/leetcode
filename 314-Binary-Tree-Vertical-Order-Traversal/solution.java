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
    private class DNode {
        List<Integer> vals = new ArrayList<>();
        DNode left;
        DNode right;
    }

    private class Pair {
        DNode link;
        TreeNode tree;

        Pair(DNode link, TreeNode tree) {
            this.link = link;
            this.tree = tree;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        
        if (root == null)
            return rst;

        Queue<Pair> queue = new LinkedList<>();
        DNode mid = new DNode();
        queue.offer(new Pair(mid, root));
        DNode leftMost = mid;

        while (!queue.isEmpty()) {
            Queue<Pair> next = new LinkedList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pair curr = queue.poll();
                DNode link = curr.link;
                TreeNode tree = curr.tree;

                link.vals.add(tree.val);

                if (tree.left != null) {
                    if (link.left == null) {
                        link.left = new DNode();
                        link.left.right = link;
                        leftMost = link.left;
                    }
                    next.add(new Pair(link.left, tree.left));
                }

                if (tree.right != null) {
                    if (link.right == null) {
                        link.right = new DNode();
                        link.right.left = link;
                    }
                    next.add(new Pair(link.right, tree.right));
                }
            }

            queue = next;
        }

        while (leftMost != null) {
            rst.add(leftMost.vals);
            leftMost = leftMost.right;
        }

        return rst;
    }
}