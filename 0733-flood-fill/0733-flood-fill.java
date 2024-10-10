class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc=image[sr][sc];
        if(oc!=color){
            dfs(image,sr,sc,color, oc);
        }
        return image;
    }
    public void dfs(int[][] img,int r,int c,int nc, int oc){
        if(r<0||r>=img.length||c<0||c>=img[0].length||img[r][c]!=oc) return;
        img[r][c]=nc;

        dfs(img,r+1,c,nc,oc);
        dfs(img,r-1,c,nc,oc);
        dfs(img,r,c+1,nc,oc);
        dfs(img,r,c-1,nc,oc);

    }
}