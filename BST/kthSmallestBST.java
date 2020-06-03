/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

class Ele {
    int kCheck=0;
    int ans=0;
}
class kthSmallestBST {
    public void kthSmallestRecur(TreeNode root, int k, Ele ele)
    {
        if(root==null) return;
        kthSmallestRecur(root.left,k,ele);
        ele.kCheck++;
        if(ele.kCheck==k)
            ele.ans=root.val;
        kthSmallestRecur(root.right,k,ele);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        Ele obj = new Ele();
        kthSmallestRecur(root,k,obj);
        return obj.ans;
            
        
    }
}
