class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> al=new ArrayList<>();
            al.add(1);

            for(int j=1;j<i;j++){
                int v=res.get(i-1).get(j-1)+res.get(i-1).get(j);
                al.add(v);
            }
            if(i>0) al.add(1);
            res.add(al);
        }
        return res;
    }
}