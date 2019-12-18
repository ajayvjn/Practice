package matrix;

/**
 * Created by Ajay on 9/18/17.
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * <p>
 * STEPS:
 * Do DFS from every cell
 * Compare every 4 direction and skip cells that are out of boundary or smaller
 * Get matrix max from every cell's max
 * Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * The key is to cache the distance because it's highly possible to revisit a cell
 */
public class LongestSequence {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] M = {{0, 1, 1, 1, 0}, {1, 0, 5, 0, 1}, {0, 3, 4, 0, 1}, {1, 1, 0, 1, 0}};
        System.out.println(new LongestSequence().longestIncreasingPath(M));
    }

    private int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

}
