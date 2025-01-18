class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        HashMap<Integer, Integer> hm=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int el=entry.getKey();
            int c=entry.getValue();
            if(c>n) res.add(el);
        }
        return res;
    }
}