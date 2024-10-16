class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indeg=new int[numCourses];
        int[] res=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

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
            res[in++]=course;
            for(int nc: adj.get(course)){
                indeg[nc]--;
                if(indeg[nc]==0) q.add(nc);
            }
        }
        if(in!=numCourses) return new int[0];

        return res;
    }
}