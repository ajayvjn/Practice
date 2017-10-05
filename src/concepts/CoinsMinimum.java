package concepts;

/**
 * Created by Ajay on 8/30/17.
 *
 * QUESTIONS
 *  What kind of coin system should I use.
 *
 */
public class CoinsMinimum {
    public static void main(String[] args) {
        int[] coins = { 25, 10, 5, 1 };
        int n = 32;
        System.out.println(findMinCoins(n, coins));
        System.out.println(findMinCoinsRecursive(n, coins));
        System.out.println(findMinCoinsDP(n, coins));
    }

    private static int findMinCoins(int n, int[] coins) {
        int min = 0;
        while(n > 0){
            for (int i = 0; i < coins.length; i++) {
                if(n - coins[i] >= 0){
                    n = n - coins[i];
                    min++;
                    break;
                }
            }
        }
        return min;
    }

    private static int findMinCoinsRecursive(int n, int[] coins) {
        if (n == 0)
            return 0;

        int min  = n;

        for (int i = 0; i < coins.length; i++) {
            if (n - coins[i] >= 0) {
                int c = findMinCoinsRecursive(n - coins[i], coins);
                if(c + 1 < min)
                    min = c + 1;
            }
        }
        return min;
    }

    private static int findMinCoinsDP(int n, int[] coins) {
        int[] cache = new int[n];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return findMinCoinsDPRecursive(n, coins, cache);
    }

    private static int findMinCoinsDPRecursive(int n, int[] coins, int[] cache ){
        if (n == 0)
            return 0;

        int min  = n;

        for (int i = 0; i < coins.length; i++) {
            if (n - coins[i] >= 0) {
                int c;
                if(cache[n-coins[i]] > 0){
                    c = cache[n-cache[i]];
                } else {
                    c = findMinCoinsRecursive(n - coins[i], coins);
                    cache[n-coins[i]] = c;
                }
                if(c + 1 < min)
                    min = c + 1;
            }
        }
        return min;
    }
}
