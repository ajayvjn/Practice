package array;

/**
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 */
public class MinimumCostForTickets {

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    private static int mincostTickets(int[] days, int[] costs) {
        // for every day in days need to travel,
        // 1.cost to have 1-pass cover this day, dp[i]=dp[i-1]+costs[0]
        // 2.cost to have 7-pass cover this day, dp[i]=dp[i-7]+costs[1]
        // 3.cost to have 30-pass cover this day, dp[i]=dp[i-30]+costs[2]
        // dp[i]=min{1,2,3}
        int[] dp = new int[366];
        for (int i = 0; i < days.length; i++)
            dp[days[i]] = -1;
        int last_day = days[days.length - 1];
        for (int i = 1; i <= last_day; i++) {
            if (dp[i] == -1) {
                int min = dp[Math.max(0, i - 1)] + costs[0];
                min = Math.min(min, dp[Math.max(0, i - 7)] + costs[1]);
                min = Math.min(min, dp[Math.max(0, i - 30)] + costs[2]);
                dp[i] = min;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[last_day];
    }
}
