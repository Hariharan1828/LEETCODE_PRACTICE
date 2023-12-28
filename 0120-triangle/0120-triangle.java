class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m= triangle.size();

        int dp[][] = new int[m][m];
    
        for(int i=0;i<m;i++){
            for(int j=0; j<m;j++){
                dp[i][j] =-1;
            }
        }
        return path(0, 0,m, triangle, dp);
        
    }
        public int path(int i, int j, int m, List<List<Integer>> triangle, int dp[][]) {
            int down =0;
            int diagonal=0;

            if (dp[i][j] != -1)
            return dp[i][j];

            if (i==m-1) {
                return triangle.get(i).get(j);
            }
            
            
            down = triangle.get(i).get(j) + path(i + 1, j, m,triangle,dp);
            diagonal = triangle.get(i).get(j) + path(i + 1, j + 1, m,triangle,dp);

            return dp[i][j] = Math.min(down, diagonal);
    }
}