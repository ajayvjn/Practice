package concepts;

/**
 * Created by Ajay on 9/24/17.
 */
public class CoinsWays {
    public static void main(String[] args) {
        int i[] = {25, 10, 5,1};
        new CoinsWays().makeChange(32, i);
    }

    private void makeChange(int money, int[] coins) {
        System.out.println(makeChange(money, coins, 0));
    }

    private int makeChange(int remaining, int coins[], int i) {
        if (remaining == 0){
            return 1;
        }
        if (i >= coins.length){
            return 0;
        }

        int amountWithCoin = 0;
        int ways = 0;

        while(amountWithCoin <= remaining){
            ways += makeChange(remaining - amountWithCoin, coins, i+1);
            amountWithCoin += coins[i];
        }

        return ways;
    }
}
