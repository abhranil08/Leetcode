/*

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.
*/



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

class Sum {
    int s=0;
}
class rangeSumOfBST {
    public void rangeSum(TreeNode root, int L, int R, Sum obj)
    {
        if(root==null) return;
        if(root.val>=L && root.val<=R)
            obj.s+=root.val;
        if(root.left!=null)
        {
            if(root.val>L)
                rangeSum(root.left,L,R,obj);
        }
        if(root.right!=null)
        {
            if(root.val<R)
                rangeSum(root.right,L,R,obj);
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        Sum obj = new Sum();
        rangeSum(root,L,R,obj);
        return obj.s;
        
        
    }
}
