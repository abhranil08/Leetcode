/*

Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree)
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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key)
        {
            root = delete(root,key);
        }
        else if(key<root.val)
            root.left = deleteNode(root.left,key);
        else
            root.right = deleteNode(root.right,key);
        return root;
    }
    private TreeNode delete(TreeNode root,int key)
    {
        if(root.left==null && root.right==null)
            return null;
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        TreeNode temp = root.right;
        while(temp.left!=null)
            temp=temp.left;
        temp.left = root.left;
        return root.right;
        
    }
    
}       
