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
        dfs(rst, root, "");
        return rst;
    }
    
    void dfs(List<String>rst, TreeNode root, String path) {
        if (root == null) {
            return;
        }
        
        path = path + root.val;
        
        if (root.left == null && root.right == null) {
            rst.add(new String(path));
        }
        
        if (path.length() >= 1)
            path += "->";
        
        dfs(rst, root.left, path);
        dfs(rst, root.right, path);
        path = path.substring(0, path.length()-1);
    }
}