package array;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
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
