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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll=new LinkedList<>();
        Queue<TreeNode> q=new LinkedList<>();
        
        if(root==null) return ll;
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> cl=new LinkedList<>();
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                cl.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            ll.add(cl);
        }
        return ll;
    }
}