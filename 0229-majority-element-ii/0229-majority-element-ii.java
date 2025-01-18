class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //array can at max have only 2 ele greater than n/3 times at a time
        List<Integer> result= new ArrayList<>();
        int n= nums.length;
        int count1 =0;
        int count2=0;
        int candidate1=Integer.MIN_VALUE;
        int candidate2=Integer.MIN_VALUE;

        for(int num: nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if(count1 ==0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 ==0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        //verify the two candidiates are correct or not
        count1=0;
        count2=0;

        for(int num: nums){
            if(num ==candidate1){
                count1++;
            }
            else if(num ==candidate2){
                count2++;
            } 
        }

        if(count1> n/3){
            result.add(candidate1);
        }
        if(count2> n/3){
            result.add(candidate2);
        }
        return result;
    }
}