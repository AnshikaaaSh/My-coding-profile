/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(q.val<root.val && p.val<root.val) root=root.left;
            else if(q.val>root.val && p.val>root.val) root=root.right;
            else break;
        }
        return root;
    }
}