class Solution {
    public int fib(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        
        return fibonacci(dp, n);
        
    }
    public int fibonacci(int dp[], int n){
        if(n<=1) return n;

        if(dp[n]!=-1) return dp[n];

        dp[n]= fibonacci(dp, n-1)+fibonacci(dp, n-2);

        

        return dp[n];
    
    }
}