/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node 
never differ by more than 1.

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sortedArrayToBinarySearchTree {
    public TreeNode sortedArrayRecur(int[] nums, int l, int h)
    {
        if(l>h)
            return null;
        int mid=(l+h+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayRecur(nums,l,mid-1);
        root.right = sortedArrayRecur(nums,mid+1,h);
        return root;
        
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayRecur(nums,0,nums.length-1);
        
    }
}
