class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indeg=new int[numCourses];

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }
        int in=0;
        while(!q.isEmpty()){
            int course=q.poll();
            in++;
            for(int nc:adj.get(course)){
                indeg[nc]--;
                if(indeg[nc]==0) q.add(nc);
            }
        }
        if(in!=numCourses) return false;
        return true;
    }
}