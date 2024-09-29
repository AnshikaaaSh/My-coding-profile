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
    public static void inorder(TreeNode root, List<Integer> ll){
        if(root==null) return;
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll=new LinkedList<>();
        inorder(root,ll);
        return ll;
    }
}