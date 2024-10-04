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
class NodeValue{
    public int maxNode, minNode, maxsum;
    NodeValue(int maxNode,int minNode, int maxsum){
        this.maxNode=maxNode;
        this.minNode=minNode;
        this.maxsum=maxsum;
    }
}
class Solution{
    int max=0;
    public NodeValue large(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
        }

        NodeValue left=large(root.left);
        NodeValue right=large(root.right);

        if(left.maxNode<root.val && root.val<right.minNode){
            max=Math.max(max, left.maxsum+right.maxsum+root.val);
            return new NodeValue(Math.max(root.val, right.maxNode),
                                Math.min(root.val,left.minNode),
                                right.maxsum+left.maxsum+root.val);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxsum, right.maxsum));
    }

    public int maxSumBST(TreeNode root){
        large(root);
        return max;
    }
}