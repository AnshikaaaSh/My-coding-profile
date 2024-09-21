class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=0;
        int n=nums.length;
        int m=n-k+1;
        if(n==0||k==0) return new int[0];
        Deque<Integer> s=new ArrayDeque<Integer>();
        int[] ss=new int[m];
        for(int i=0;i<n;i++){
            if(!s.isEmpty() && s.peek()==i-k){
                s.poll();
            }
            while(!s.isEmpty() && nums[s.peekLast()]<nums[i]){
                s.pollLast();
            }
            s.offer(i);
            if(i>=k-1){
                ss[max++]=nums[s.peek()];
            }
        }
        return ss;
    }
}