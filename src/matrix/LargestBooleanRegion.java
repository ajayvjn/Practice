package matrix;

/**
 * Created by Ajay on 9/18/17.
 * <p>
 * {0, 0, 1, 1, 0},
 * {0, 0, 1, 1, 0}
 * {0, 1, 0, 0, 0}
 * {0, 0, 0, 0, 1}
 */
public class LargestBooleanRegion {
    public static void main(String[] args) {
        int M[][] = {{0, 0, 1, 1, 0}, {0, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(new LargestBooleanRegion().findLargestRegion(M));
    }

    private int findLargestRegion(int[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    int tmp = largestRegion(m, i, j);
                    count = Math.max(count, tmp);
                }
            }
        }
        return count;
    }

    private int largestRegion(int[][] m, int i, int j) {
        if (i < 0 || j < 0 || i >= m.length || j >= m[i].length) {
            return 0;
        }
        if (m[i][j] == 0){
            return 0;
        }

        m[i][j] = 0;
        int size = 1;
        for (int k = i-1; k <= i + 1; k++) {
            for (int l = j-1; l <= j+1; l++) {
                if (i != k || j != l){
                    size += largestRegion(m, k, l);
                }
            }

        }
        return size;
    }
}
