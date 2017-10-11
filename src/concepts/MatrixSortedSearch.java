package concepts;

/**
 * Created by Ajay on 10/11/17.
 *
 * QUESTIONS:
 *      What should I do in case of duplicate values?
 *      What kind of values are there in the array?
 *
 * Use property of sorted matrix to solve it in O(m+n)
 */

public class MatrixSortedSearch {

    public static void main(String[] args) {
        int m[][] = {{0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};

        System.out.println(new MatrixSortedSearch().isPresent(m, 9));
    }

    private boolean isPresent(int m[][], int num) {
        if (m.length == 0 || m[0].length == 0) return false;

        int row = 0;
        int col = m[0].length - 1;

        while (row < m.length && col >= 0) {
            if (m[row][col] == num)
                return true;
            else if (m[row][col] < num)
                row++;
            else
                col--;
        }

        return false;
    }

}
