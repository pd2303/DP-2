// Time Complexity : O(mn) Where m is size of coins array and n is amount. Time required to fill 2D array
// Space Complexity : O(mn) because at max we will only be having O(26) key which is constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null || coins.length==0) return 0;
        
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<=m;i++)
        {
            for (int j=0;j<=n;j++)
            {
                if(j<coins[i-1]) //if amount is less than value of coin then update the column with values of column in previous row
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    //cas1 + case2 i.e. to choose a coin or not
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
