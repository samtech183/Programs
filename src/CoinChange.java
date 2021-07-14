import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    static int rec(int[] coins , int amountLeft , Map<Integer, Integer> memo) {

        if(amountLeft==0) {
            return  0;
        }
        if(memo.get(amountLeft)!=null) {
            return memo.get(amountLeft);
        }

        int mini = 10000000;
        for(int i=0;i<coins.length;i++) {
            int val = coins[i];
            if(amountLeft - val >= 0) {
                mini = Math.min(1 + rec(coins , amountLeft - val , memo) , mini);
            }

        }
        memo.put(amountLeft , mini);
        return  mini;
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int ans =rec(coins , amount  , memo);
        if(ans == 10000000) return -1;
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        CoinChange coinChange=  new CoinChange();
        coinChange.coinChange(coins , 11);
    }


}
