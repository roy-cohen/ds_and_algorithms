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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.right = invertTree(root.left);
        newRoot.left = invertTree(root.right);
        
        return newRoot;
    }
    
}