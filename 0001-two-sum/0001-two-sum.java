class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c=target-nums[i];
            if(nmap.containsKey(c)){
                return new int[]{nmap.get(c),i};
            }
            nmap.put(nums[i], i);
        }
        return new int[]{};
    }
}