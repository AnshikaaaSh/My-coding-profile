class KthLargest {
    public int kk=0;
    ArrayList<Integer> al=new ArrayList<>();
    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++){
            al.add(nums[i]);
        }
        kk=k;
    }
    
    public int add(int val) {
        al.add(val);
        Collections.sort(al, Collections.reverseOrder());
        return al.get(kk-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */