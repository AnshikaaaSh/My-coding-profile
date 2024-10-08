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
    public static void postorder(TreeNode root, List<Integer> ll){
        if(root==null) return;
        postorder(root.left,ll);
        postorder(root.right,ll);
        ll.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll= new LinkedList<Integer>();
        postorder(root,ll);
        return ll;
    }
}