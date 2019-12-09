package array;

public class JumpGameII {
    public static void main(String[] args) {

        System.out.println(jump(new int[]{2, 1, 1, 1, 4}));
    }

    private static int jump(int[] nums) {
        return jump(nums, 0, 0);

    }

    private static int jump(int[] nums, int i, int count) {
        if (nums[i] + count >= nums.length) {
            return count;
        }

        int min = 0;
        int j = 1;
        while (j <= nums[i]) {
            int jump = jump(nums, i + 1, count);
            min = Math.min(min, jump);
            j++;
        }
        return count + min;
    }
}
