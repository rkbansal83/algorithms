package algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinsChangeMin {

    public static void main(String[] args) {
        int[] denominations = {4,3,1};
        int amount = 6;
        int minCoins = coinChange(denominations,amount);
        System.out.println("Min coins Result using recursive method "+minCoins);
      
        minCoins = coinChangeTopDownDP(denominations,amount,new HashMap<Integer,Integer>());
        System.out.println("coins Result topDownDp method "+minCoins);
        
        minCoins=coinChangeBottomUpDp(denominations,amount);
        System.out.println("coins Result bottomupDp method "+minCoins);
    }
    
    static int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(amount-coins[i]>=0){
                int count = coinChange(coins,amount-coins[i]);
                if(min>count) 
                    min=count;
            }
            
        }
        min =(min == Integer.MAX_VALUE ? min : min + 1);
        
        return min;
    }
    
    static int coinChangeTopDownDP(int[] coins, int amount,Map<Integer, Integer> map) {
        if(amount==0)
            return 0;
        if ( map.containsKey(amount) ) {
            return map.get(amount);
        }
        int min = amount;
        for(int i=0;i<coins.length;i++){
            if(amount-coins[i]>=0){
                int count = coinChange(coins,amount-coins[i]);
                if(min>count+1) 
                    min=count+1;
            }
            
        }
        map.put(amount, min);
        return min;
    }
    
    static int coinChangeBottomUpDp(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        dp[0]=0;
        int[] result = new int[amount+1];
        result[0]=-1;
        for(int i=1;i<=amount;i++)
        {
            dp[i]=Integer.MAX_VALUE-1;
            result[i]=-1;
                    
        }
        for(int i=0;i<coins.length;i++) {
            for(int j=1;j<=amount;j++){
                if(coins[i]<=j && dp[j]>1+dp[j-coins[i]]){
                    dp[j]=1+dp[j-coins[i]];
                    result[j]=i;
                }
                
            }
            
        }
        displayCoins(coins,result);
        return dp[amount];
        
    }
    
    static void displayCoins(int[] coins,int[] result){
        int coinIdx=result[result.length-1];
        int amount = result.length-1;
        System.out.println("coin combination");
        while(coinIdx!=-1){
            System.out.print(coins[coinIdx]+" ");
            amount = amount-coins[coinIdx];
            coinIdx = result[amount];
        }
        System.out.println("\n");
    }
    
    
}
