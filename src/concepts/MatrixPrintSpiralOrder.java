package concepts;

/**
 * Created by Ajay on 11/6/17.
 */
public class MatrixPrintSpiralOrder {

    public static void main(String[] args) {
        int a[][] = {{0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};

        new MatrixPrintSpiralOrder().print(a, a.length, a[0].length);
    }

    private void print(int[][] a, int row, int col) {
        int r1 = 0;
        int rn = row - 1;
        int c1 = 0;
        int cn = col - 1;
        int dir = 0;

        while ((r1 <= rn) && (c1 <= cn)) {
            if (dir == 0) {
                for (int i = c1; i <= cn; i++) {
                    System.out.print(a[r1][i] + " ");
                }
                r1++;
                dir = 1;
            } else if (dir == 1){
                for (int i = r1; i <= rn; i++) {
                    System.out.print(a[i][cn] + " ");
                }
                cn--;
                dir = 2;
            } else if (dir == 2){
                for (int i = cn; i >= c1; i--) {
                    System.out.print(a[rn][i] + " ");
                }
                rn--;
                dir = 3;
            } else {
                for (int i = rn; i >= r1; i--) {
                    System.out.print(a[i][c1] + " ");
                }
                c1++;
                dir = 0;
            }
        }
    }
}
