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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode lastLarger = null;

        /**
         * put curr to p in the tree
         */
        while (curr != p) {
            if (curr.val < p.val) {
                curr = curr.right;
            } else {
                lastLarger = curr;
                curr = curr.left;
            }
        }

        if (curr.right != null) {
            /**
             * if p in tree has right child
             * the successor is the left most child of right tree
             */
            curr = curr.right;

            while (curr.left != null)
                curr = curr.left;

            return curr;
        } else {
            // if else, its the last node on the path has value > p
            return lastLarger;
        }
    }
}