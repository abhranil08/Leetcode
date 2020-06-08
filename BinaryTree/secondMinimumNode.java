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
class secondMinimumNode.java {
    public int findSecondMinimumValue(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode second=null;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
            if(temp.val != root.val)
            {
                if(second==null)
                    second=temp;
                else
                    second.val=Math.min(second.val,temp.val);
            }
        }
        if(second==null) return -1;
        else return second.val;
        
        
    }
}
