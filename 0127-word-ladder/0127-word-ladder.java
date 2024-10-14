class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> ws=new HashSet<>(wordList);
        if(!ws.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

        int level=1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String cword=q.poll();
                for(int j=0;j<cword.length();j++){
                    char[] arr=cword.toCharArray();
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String tword=new String(arr);
                        if(tword.equals(endWord)) return level+1;
                        if(ws.contains(tword)){
                            q.add(tword);
                            ws.remove(tword);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
        
    }
}