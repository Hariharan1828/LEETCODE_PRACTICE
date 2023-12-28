class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
    
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                dp[i][j] =-1;
            }
        }
        return path(m - 1, n - 1, grid, dp);
    }

    public int path(int m, int n, int[][] grid, int dp[][]) {
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        
        if(dp[m][n]!=-1) return dp[m][n];
        
        int up = m > 0 ? grid[m][n] + path(m - 1, n, grid, dp) : Integer.MAX_VALUE;
        int left = n > 0 ? grid[m][n] + path(m, n - 1, grid,dp) : Integer.MAX_VALUE;

        return dp[m][n] = Math.min(up, left);
    }
}
