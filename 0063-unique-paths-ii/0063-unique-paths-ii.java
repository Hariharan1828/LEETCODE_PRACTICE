
//Memoization

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][]= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                dp[i][j] = -1;
            }
        }
        return path( m-1, n-1, dp, obstacleGrid);

        
    }
    public int path(int m ,int n, int dp[][], int[][] oG) {
        int up =0;
        int left =0;
        if(m>=0 && n>=0 && oG[m][n]==1 ) return 0; //only change from unique paths
        if(m==0 && n==0) return 1;
        if(n<0||m<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        up = path(m-1,n, dp, oG);
        left = path(m,n-1,dp, oG);
        
        return dp[m][n]= up+left;

        
        

    }
}