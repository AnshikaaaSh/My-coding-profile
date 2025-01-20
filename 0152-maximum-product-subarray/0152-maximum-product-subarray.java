class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0], max=nums[0], ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int t=max;
            max=Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min=Math.min(Math.min(t*nums[i],min*nums[i]),nums[i]);
            if(max>ans) ans=max;
        }
        return ans;
    }
}