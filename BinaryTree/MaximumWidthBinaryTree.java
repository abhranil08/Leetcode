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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int maxWidth = 0;
        q.add(root);

        while( !q.isEmpty() )
        {
            int size = q.size();
            System.out.println("size " + size);                  
            maxWidth = Math.max(size, maxWidth);
            for( int i = 0; i < size; i++ )
            {
                TreeNode current = q.peek();
                if( current != null )
                {
                    System.out.print(current.val + " ");
                    q.add(current.left);
                    q.add(current.right);
                }
                q.remove();
            }
            System.out.println();
        }
        return maxWidth;
    }
}
