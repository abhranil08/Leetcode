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

class Index {
    int x;
}
class preorderToBst {
    
    public TreeNode bst(int[] preorder, Index preIndex, int low, int high,int size)
    {
        if(preIndex.x>=size || low>high)
            return null;
        TreeNode root = new TreeNode(preorder[low]);
        preIndex.x=preIndex.x+1;
        
        if(low==high)
            return root;
        
        int i=0;
        for(i=low;i<=high;i++)
        {
            if(preorder[i]>root.val)
                break;
        }
        root.left = bst(preorder,preIndex,preIndex.x,i-1,size);
        root.right = bst(preorder,preIndex,i,high,size);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        Index preIndex = new Index();
        //int size = preorde.size;
        return bst(preorder,preIndex,0,(preorder.length)-1,preorder.length);
        
    }
}
