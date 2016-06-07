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
    class ReturnType {
        int length;
        int val;

        public ReturnType(int length, int val) {
            this.length = length;
            this.val = val;
        }
    }

    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        helper(root, null);

        return max;
    }

    private ReturnType helper(TreeNode root, TreeNode prev) {
        if (root == null)
            return new ReturnType(0, 0);

        ReturnType left = helper(root.left, root);
        ReturnType right = helper(root.right, root);

        int tmp = 0;
        if (left.length != 0 && left.val - root.val == 1) {
            tmp = left.length + 1;
            max = Math.max(tmp, max);
        }

        if (right.length != 0 && right.val - root.val == 1) {
            tmp = Math.max(tmp, right.length + 1);
            max = Math.max(tmp, max);
        }

        if (tmp > 0)
            return new ReturnType(tmp, root.val);
        else
            return new ReturnType(1, root.val);
    }
}