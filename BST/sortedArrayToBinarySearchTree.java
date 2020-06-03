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
