class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> l=new ArrayList<>();
        
        int start=intervals[0][0], end=intervals[0][1];
        for(int[] i:intervals){
            if(i[0]<=end) end=Math.max(end,i[1]);
            else{
                l.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        l.add(new int[]{start,end});
        return l.toArray(new int[0][]);
    }
}