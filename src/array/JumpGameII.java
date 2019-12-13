package array;

/**
 * Example:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameII {
    public static void main(String[] args) {

        System.out.println(jump(new int[]{2, 1, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    private static int jump(int[] nums) {
        return jump(nums, 0, 0);

    }

    private static int jump(int[] nums, int i, int count) {
        if (nums[i] + count >= nums.length) {
            return count;
        }

        int min = Integer.MAX_VALUE;
        int j = 1;
        while (j <= nums[i]) {
            int jump = jump(nums, i + j, count+1);
            min = Math.min(min, jump);
            j++;
        }
        return min;
    }
}
