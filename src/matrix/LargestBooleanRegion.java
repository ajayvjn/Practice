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

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
        if (i < 0 || j < 0 || i >= m.length || j >= m[i].length || m[i][j] == 0) {
            return 0;
        }

        m[i][j] = 0;
        int size = 1;

        for (int[] direction : directions) {
            size += largestRegion(m, i + direction[0], j + direction[1]);
        }

        // the above loop can be also dine like this
        /*largestRegion(m, i-1, j);
        largestRegion(m, i+1, j);
        largestRegion(m, i, j-1);
        largestRegion(m, i, j+1);*/

        return size;
    }
}
