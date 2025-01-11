class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans=new int[nums.length];
        int pi=0, ni=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[pi]=nums[i];
                pi+=2;
            }
            else{
                ans[ni]=nums[i];
                ni+=2;
            }
        }
        return ans;
    }
}