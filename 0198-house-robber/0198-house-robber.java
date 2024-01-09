class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] arr = nums;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return count(n-1, arr, dp);
        
    }
    
    public static int count(int n , int[] nums, int[] dp){
        if(n==0) return nums[n];
        
        if(n<0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        
        int pick = nums[n]+count(n-2, nums, dp);
        int non_pick = count(n-1, nums,dp);
        
        return dp[n]= Math.max(pick, non_pick);
    }
    
}