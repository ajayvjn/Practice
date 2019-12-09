package matrix;

/**
 * Created by Ajay on 9/18/17.
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 */
public class NumberOfIslands {

    private int[][] point = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int m[][] = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(new NumberOfIslands().noOfIslands(m));
    }

    private int noOfIslands(int[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    goDFS(m, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void goDFS(int[][] m, int i, int j) {
        if (i < 0 || j < 0 || i >= m.length || j >= m[i].length || m[i][j] == 0) {
            return;
        }
        m[i][j] = 0;
        for (int[] p : point) {
            goDFS(m, i + p[0], j + p[1]);
        }
    }
}
