class Solution {
   static boolean canPartition(int[] arr) {

       int n= arr.length;
        // Calculate the total sum of the array elements
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totSum % 2 == 1) 
            return false;
        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;
            // Create a DP table to store the results of subproblems
            boolean dp[][] = new boolean[n][k + 1];

            // Initialize the first row of the DP table
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // Initialize the first column of the DP table
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }

            // Fill in the DP table using bottom-up dynamic programming
            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {
                    // Calculate if the current element is not taken
                    boolean notTaken = dp[ind - 1][target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = dp[ind - 1][target - arr[ind]];
                    }

                    // Update the DP table for the current element and target sum
                    dp[ind][target] = notTaken || taken;
                }
            }

            // The result is stored in the last cell of the DP table
            return dp[n - 1][k];
        }
    }

    // public static boolean CheckPart(int[] nums, int n){
        
    //     int s=0;
    //     for(int i=0;i<n;i++) s+=nums[i];

    //     if(s%2==1) return false;
    //     int target = s/2;

    //     int dp[][] = new int[n][target+1];

    //     for(int row[] : dp){
    //         Arrays.fill(row, -1);
    //     } 

    //     return SubPartTarget(n-1, nums, target, dp);       

    // } 
    // public static boolean SubPartTarget(int n, int nums[], int target, int dp[][]){
    //     if(target==0) return true;

    //     if(n==0) return nums[0]==target;

    //     if(dp[n][target]==-1) return dp[n][target]==0? false: true;
        
    //     boolean notPick = SubPartTarget(n-1, nums, target,dp );
    //     boolean Pick= false;

    //     if(nums[n] <= target) Pick = SubPartTarget(n-1, nums, target-nums[n],dp);

    //     dp[n][target]= Pick||notPick ?1:0;

    //     return Pick||notPick; 

    // }
}