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
class BSTIterator {
    ArrayList<Integer> al=new ArrayList<>();
    int id=-1;

    public void inod(TreeNode root){
        if(root==null) return;
        inod(root.left);
        al.add(root.val);
        inod(root.right);
    }

    public BSTIterator(TreeNode root) {
        inod(root);
    }
    
    public int next() {
        id++;
        return al.get(id);
    }
    
    public boolean hasNext() {
        if(id+1<al.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */