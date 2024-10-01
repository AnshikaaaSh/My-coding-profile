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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        if(n==0|| nums==null) return null;
        return sarr(nums, 0,n-1);
    }
    private TreeNode sarr(int[] nums,int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=sarr(nums,l,mid-1);
        node.right=sarr(nums,mid+1,r);
        return node;
    }
}