class Solution {
public:
    int integerBreak(int n) {
        vector<int> memo(n+1, -1);
        return solve(n, memo);
    }

    int solve(int n, vector<int>& memo)
    {
        if (n==1) return 1;
        if (memo[n] != -1) return memo[n];
        int maxProd = 0;
        for(int i=1; i < n; ++i)
        {
            maxProd = max(maxProd, max(i * (n-i), i * solve(n-i,memo)));
        }
        memo[n] = maxProd;
        return maxProd;
    }
};