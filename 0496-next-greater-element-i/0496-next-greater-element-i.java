class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a=new int[nums1.length];
        Arrays.fill(a,-1);
        int in=0;
        
        for(int i=0;i<nums1.length;i++){
            in=0;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) in=1;
                if(nums2[j]>nums1[i] && in==1){
                    a[i]=nums2[j];
                    break;
                }
            }
        }
        
        return a;
    }
}