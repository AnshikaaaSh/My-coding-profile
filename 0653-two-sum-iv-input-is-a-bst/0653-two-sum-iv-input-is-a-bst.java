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
    int ans=0;
    boolean s;
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ll=new ArrayList<Integer>();
        inod(root,ll);

        int l=0, r=ll.size()-1;
        while(l<r){
            int sum=ll.get(l)+ll.get(r);
            if(sum==k) return true;
            else if(sum<k) l++;
            else r--;
        }
        return false;
    }
    public void inod(TreeNode root, List<Integer> ll){
        if(root==null) return;
        inod(root.left,ll);
        ll.add(root.val);
        inod(root.right,ll);
    }
}