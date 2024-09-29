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
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ll=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            ll.add(root.val);
            root=root.right;
        }
        return ll;
    }
}