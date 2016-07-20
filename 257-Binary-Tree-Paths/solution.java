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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(rst, root, sb);
        return rst;
    }
    
    void dfs(List<String>rst, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        
        int len = sb.length();
        sb.append(root.val);
        
        if (root.left == null && root.right == null) {
            rst.add(sb.toString());
        }
        
        if (sb.length() >= 1) {
            sb.append("->");
        }
        
        dfs(rst, root.left, sb);
        dfs(rst, root.right, sb);
        sb.setLength(len);
        
    }
}