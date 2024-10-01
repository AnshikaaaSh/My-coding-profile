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
    public int maxPathSum(TreeNode root) {
        int[] maxv=new int[1];
        maxv[0]=Integer.MIN_VALUE;
        maxpath(root,maxv);
        return maxv[0];
    }
    private int maxpath(TreeNode root, int[] maxv){
        if(root==null) return 0;
        int left=Math.max(0,maxpath(root.left,maxv));
        int right=Math.max(0,maxpath(root.right,maxv));

        maxv[0]=Math.max(maxv[0], left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}