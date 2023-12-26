class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inital_colour = image[sr][sc];
        int[][] ans = image;

        int del_row[] = {-1,0,+1,0};
        int del_col[]= {0,+1,0,-1};

        dfs(sr,sc,ans, image, color, inital_colour, del_row, del_col);
        return ans;
        
    }
    static void dfs(int row, int col, int[][] ans, int[][] image, int color, int initial_colour, int del_row[], int del_col[] ){

        ans[row][col]= color;
        int n= image.length;
        int m= image[0].length;

        for(int i=0; i<4;i++){
            int n_row = row + del_row[i];
            int n_col = col + del_col[i];

            if(n_row >=0 &&n_row<n && n_col>=0 && n_col<m && image[n_row][n_col]==initial_colour && ans[n_row][n_col]!=color){
                dfs(n_row, n_col, ans, image, color, initial_colour, del_row, del_col);
            } 
        }
    }
}