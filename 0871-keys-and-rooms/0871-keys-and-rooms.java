class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();

        vis[0]=true;
        q.add(0);

        while(!q.isEmpty()){
            int r=q.poll();
            for(int k:rooms.get(r)){
                if(!vis[k]){
                    vis[k]=true;
                    q.add(k);
                }
            }
        }
        for(boolean rv:vis){
            if(!rv) return false;
        }
        return true;
    }
}