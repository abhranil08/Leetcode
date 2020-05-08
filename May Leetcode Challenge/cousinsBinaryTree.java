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
class Parent {
    int x;
}
class Solution {
    public void parent(TreeNode root,int x,Parent obj)
    {
        if(root==null)
            return;
        
        if(root.left!=null)
        {
            if(root.left.val==x)
                {
                    obj.x=root.val;
                    return;
                }
        }
        
        if(root.right!=null)
        {
            if(root.right.val==x)
                {
                    obj.x=root.val;
                    return;
                }
        }
        parent(root.left,x,obj);
        parent(root.right,x,obj);
    }
    
    public int depth(TreeNode root, int x,int level)
    {
        if(root==null)
            return 0;
        if(root.val==x)
            return level;
        int dep = depth(root.left,x,level+1);
        if(dep!=0)
            return dep;
        else
            return depth(root.right,x,level+1);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        Parent obj1=new Parent(); 
        Parent obj2=new Parent();
        
        parent(root,y,obj1); 
        parent(root,x,obj2);
        
        if((depth(root,x,0) == depth(root,y,0)) && (obj1.x!=obj2.x))
            return true;
        else
            return false;
        
    }
}
