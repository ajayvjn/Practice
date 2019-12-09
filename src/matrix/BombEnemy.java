package matrix;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class BombEnemy {

    public static void main(String[] args) {
        char[][] m = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(maxKilledEnemies(m));
    }

    private static int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        int max = 0;
        int row = 0;
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') continue;
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = getRow(grid, i, j);
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = getCol(grid, i, j);
                }

                if (grid[i][j] == '0' && row + cols[j] > max) {
                    max = row + cols[j];
                }
            }
        }
        return max;
    }

    private static int getRow(char[][] grid, int i, int j) {
        int rt = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') rt++;
            j++;
        }
        return rt;
    }

    private static int getCol(char[][] grid, int i, int j) {
        int rt = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') rt++;
            i++;
        }
        return rt;
    }
}