/*

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key 
plus sum of all keys greater than the original key in BST.

/*

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
class convertBSTToGreaterTree {
    public void convertToBST(TreeNode root, Sum obj)
    {
        if(root==null)
            return;
        //root.val=+obj.s;
        convertToBST(root.right,obj);
        int temp2=root.val;
        root.val+=obj.s;
        obj.s+=temp2;
        convertToBST(root.left,obj);
    }
    public TreeNode convertBST(TreeNode root) {
        Sum obj = new Sum();
        convertToBST(root,obj);
        return root;
        
    }
}
