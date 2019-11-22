package matrix;

/*

You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

        Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

        Example:

        Input:
        [['O', 'O', 'O', 'O'],
        ['D', 'O', 'D', 'O'],
        ['O', 'O', 'O', 'O'],
        ['X', 'D', 'D', 'O']]

        Output: 5
        Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
*/


import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = treasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
    }

    private static int treasureIsland(char[][] island) {
        boolean visited[][] = new boolean[island.length][island[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int steps = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int a[] = q.poll();
                int x = a[0];
                int y = a[1];
                if (island[x][y] == 'X') {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx >= 0 && yy >= 0 && xx < island.length && yy < island[0].length && island[xx][yy] != 'D' && !visited[xx][yy]) {
                        q.add(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }

}
