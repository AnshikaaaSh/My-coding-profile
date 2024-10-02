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
        TreeNode roott=root;
        while(roott!=null){
            if(q.val<roott.val && p.val<roott.val) roott=roott.left;
            else if(q.val>roott.val && p.val>roott.val) roott=roott.right;
            else break;
        }
        return roott;
    }
}