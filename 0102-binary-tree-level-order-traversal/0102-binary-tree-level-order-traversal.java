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
        List<List<Integer>> ll=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ll;
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> cl=new ArrayList<>();
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode currNode=q.poll();
                cl.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            ll.add(cl);
        }
        return ll;
    }
}