class Solution {
    public void fun(int[] indeg, int[][] pre){
        for(int i=0;i<pre.length;i++) indeg[pre[i][0]]++;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg=new int[numCourses];
        fun(indeg, prerequisites);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0) q.add(i);
        }

        ArrayList<Integer> arr=new ArrayList<>();

        while(!q.isEmpty()){
            int curr=q.poll();
            arr.add(curr);
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==curr){
                    indeg[prerequisites[i][0]]--;
                    if(indeg[prerequisites[i][0]]==0) q.add(prerequisites[i][0]);
                }
            }
        }
        int s=arr.size();
        if(s!=numCourses) return new int[0];

        int[] res=new int[s];

        for(int i=0;i<s;i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}