class Solution {
    public int search(int[] nums, int target) {
        int mid=nums.length/2;
        if(target>nums[mid]){
            for(int i=mid;i<nums.length;i++){
                if(nums[i]==target) return i;
            }
        }
        else if(target==nums[mid]) return mid;
        else if(target<nums[mid]){
            for(int i=0;i<mid;i++){
                if(nums[i]==target) return i;
            }
        }
        else if(nums[0]==target) return 0;
        return -1;
    }
}