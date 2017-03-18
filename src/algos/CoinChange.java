package algos;

import java.util.Arrays;

/**
 * This logic computes the total number of ways 
 * to make change for given amount and unlimited supply of coins
 * @author rbansal
 *
 */
public class CoinChange {

    public static void main(String[] args){
        int[] denominations = {4,2,3};
        int amount = 4;
        
        System.out.println("No of ways to create change ::"+coinChangeRecursive(denominations,amount,0));
        System.out.println("No of ways to create change ::"+coinChangeDP(denominations,amount));
    }
    
    public static int coinChangeRecursive(int[] denominations,int amount,int currIndex) {
        if(amount==0)
            return 1;
        if(amount<0)
            return 0;
        if(amount>0 && currIndex==denominations.length)
            return 0;
     
        return coinChangeRecursive(denominations,amount-denominations[currIndex],currIndex)+coinChangeRecursive(denominations,amount,currIndex+1);
        
        
    }
    
    public static int coinChangeDP(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
           }
        }
        return dp[amount];
    }
}
 