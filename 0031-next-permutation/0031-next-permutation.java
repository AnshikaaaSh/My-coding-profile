class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length, i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i])j--;
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
        rev(nums,i+1,n-1);
    }
    public void rev(int[] nums, int s, int e){
        while(s<e){
            int t=nums[s];
            nums[s]=nums[e];
            nums[e]=t;
            s++;
            e--;
        }
    }
}