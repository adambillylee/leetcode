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
    int minCol = 0;
    int maxCol = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap();

        helper(root, map, 0);

        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for (int col = minCol; col <= maxCol; col++) {
            if (map.get(col) != null) {
                rst.add(map.get(col));
            }
        }

        return rst;
    }

    private void helper(TreeNode root, Map<Integer, List<Integer>> map, int col) {
        if (root == null) {
            return;
        }

        List<Integer> tmp;
        if (map.get(col) == null) {
            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);
            tmp = new ArrayList<>(root.val);
        } else {
            tmp = map.get(col);
        }
        tmp.add(root.val);
        map.put(col, tmp);

        helper(root.left, map, col - 1);
        helper(root.right, map, col + 1);
    }
}