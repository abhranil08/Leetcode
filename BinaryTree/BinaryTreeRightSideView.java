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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> rightSideView = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty() )
        {
            int size = q.size();
            int val = Integer.MIN_VALUE;
            for( int i = 1; i <= size; i++)
            {
                TreeNode curr = q.poll();
                if( curr != null )
                {
                    val = curr.val;
                    if(curr.left != null )
                    {
                        q.add(curr.left);
                    }
                    if(curr.right != null )
                    {
                        q.add(curr.right);
                    }
                }
                
            }
            if( val != Integer.MIN_VALUE)
                rightSideView.add(val);
        }
        return rightSideView; 
    }
}
