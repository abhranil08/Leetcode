/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

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
class Ans {
    
    /*int val; 
    TreeNode(int x) { val = x; }*/
    int x ;
}
class Solution {
    
    public TreeNode lca ( TreeNode root, TreeNode p, TreeNode q, Ans answer )
    {                       
        if( root.left == null && root.right == null ) return ( root );
        
        TreeNode left = root;
        TreeNode right = root;
        
        if( root.left != null )
            left = lca(root.left, p, q, answer);
        
        if( root.right != null )
            right = lca(root.right, p, q, answer);
       
        if ( ( root.val == q.val && ( left.val == p.val || right.val == p.val ) ) || ( root.val == p.val && ( left.val == q.val || right.val == q.val ) ) )       
            answer.x = root.val;
        
        if( ( left.val == p.val && right.val == q.val ) || ( right.val == p.val && left.val == q.val ) )
            answer.x = root.val;
   
        else if( left.val == p.val || left.val == q.val )
            return( left );
        else if( right.val == p.val || right.val == q.val )
            return( right );
        return( root );
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        /*
        Bottom Up logic
        Ans answer = new Ans( );
        TreeNode a = lca ( root, p, q, answer );
        return new TreeNode( answer.x ); */
        
        if( root == null ) return null;
        if( root == p || root == q )
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if( left != null && right != null ) return root;
        else if( left == null && right != null ) return right;
        else return left;
        
        
    }
}
