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
class Pair {
    TreeNode node;
    int pos;
    public Pair(TreeNode node, int pos )
    {
        this.node=node;
        this.pos=pos;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        int maxWidth = 1;
        q.add(new Pair(root,0));
        while( !q.isEmpty() )
        {
            int size = q.size();
            for( int i = 0; i < size; i++ )
            {
                Pair currentPair = q.remove();
                if(currentPair.node.left!=null)
                    q.add(new Pair(currentPair.node.left, 2*currentPair.pos));
                if(currentPair.node.right!=null)
                    q.add(new Pair(currentPair.node.right, 2*currentPair.pos+1));
            }
            if(!q.isEmpty())
            {
                Pair first = q.getFirst();
                Pair last = q.getLast();          
                maxWidth = Math.max(last.pos - first.pos+1, maxWidth);
            }
        }
        return maxWidth;
    }
}
