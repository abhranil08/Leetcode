/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBSTFunc( TreeNode root, long maxValue, long minValue )
    {
        if( root == null ) return true;
        if( root.val < maxValue && root.val > minValue )
            return( isValidBSTFunc( root.left, root.val, minValue ) && isValidBSTFunc( root.right, maxValue, root.val ));
        
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return( isValidBSTFunc( root, Long.MAX_VALUE, Long.MIN_VALUE ));
    }
}
