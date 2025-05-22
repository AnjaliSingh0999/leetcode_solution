class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

       
        Arrays.fill(dp, amount + 1);

    
        dp[0] = 0;

         
        for (int coin : coins) {
           
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] + 1 < dp[i]) {
            
                    dp[i] = dp[i - coin] + 1;
                } else {
                    
                    dp[i] = dp[i];
                }
            }
        }

        
        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}    