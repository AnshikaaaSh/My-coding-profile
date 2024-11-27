class Solution {
    public int reverse(int x) {
        if(x==0){
            return x;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        boolean neg = false;
        if(sb.charAt(0)=='-'){
            neg=true;
            sb.deleteCharAt(0);
        }
        sb.reverse();
        while(sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(neg==true){
            sb.insert(0,'-');
            if(sb.length()==11){
                StringBuilder str = new StringBuilder();
                str.append(Integer.MIN_VALUE);
                if(sb.compareTo(str) >= 0){
                    return 0;
                }
            }
        }
        if(sb.length()==10){
            StringBuilder str = new StringBuilder();
            str.append(Integer.MAX_VALUE);
            if(sb.compareTo(str) >= 0){
                return 0;                
            }
        }
        return (Integer.valueOf(sb.toString()));
    }
}