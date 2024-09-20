class Solution {
    public int trap(int[] height) {
        int sum=0;
        int i=0, left_m=height[i];
        int j=height.length-1, right_m=height[j];
        while(i<j){
            if(left_m<=right_m){
                sum+=(left_m-height[i]);
                i++;
                left_m=Math.max(left_m,height[i]);
            }
            else{
                sum+=(right_m-height[j]);
                j--;
                right_m=Math.max(right_m,height[j]);
            }
        }
        return sum;
    }
}