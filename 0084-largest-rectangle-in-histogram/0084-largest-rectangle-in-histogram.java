class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int max=0;
        s.push(-1);
        for(int i=0;i<heights.length;i++){
            while(s.peek()!=-1 && heights[i]<=heights[s.peek()]){
                int he=heights[s.pop()];
                int w=i-s.peek()-1;
                max=Math.max(max,he*w);
            } 
            s.push(i);
        }
        while(s.peek()!=-1){
            int h=heights[s.pop()];
            int w=heights.length-s.peek()-1;
            max=Math.max(max,h*w);
        }
        return max;
    }
}