package array;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trapWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int trapWater(int[] h) {
        int area = 0;
        int maxL = 0;
        int maxR = 0;
        int l = 0;
        int r = h.length - 1;


        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] > maxL) {
                    maxL = h[l];
                } else {
                    area += maxL - h[l];
                }
                l++;
            } else {
                if (h[r] > maxR) {
                    maxR = h[r];
                } else {
                    area += maxR - h[r];
                }
                r--;
            }
        }

        return area;
    }

}
