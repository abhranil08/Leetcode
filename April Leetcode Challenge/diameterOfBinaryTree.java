/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Height {
    int h;
}
class Solution {
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Height height=new Height();
        return diameter(root,height);
    }
    public int diameter(TreeNode root,Height height)
    {
        Height lh=new Height();
        Height rh=new Height();
        if(root==null)
        {
            height.h=0;
            return 0;
        }
        
        int ld=diameter(root.left,lh);
        int rd=diameter(root.right,rh);
        
        height.h=Math.max(lh.h,rh.h)+1;
        
        return Math.max(rh.h+lh.h,Math.max(ld,rd));
    }
}
