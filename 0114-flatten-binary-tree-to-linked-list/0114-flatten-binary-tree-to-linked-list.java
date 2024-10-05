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
    Queue<TreeNode> ll=new LinkedList<>();

    public void add(TreeNode root){
        if(root==null) return;
        ll.add(root);
        add(root.left);
        add(root.right);
    }

    public void flatten(TreeNode root) {
        add(root);
        while(!ll.isEmpty()){
            TreeNode temp=ll.poll();
            temp.right=ll.peek();
            temp.left=null;
        }
    }
}