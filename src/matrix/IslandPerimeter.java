package matrix;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ajay on 9/18/17.
 * <p>
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] m = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().islandPerimeter(m));
    }

    private int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Set<Point> closed = new HashSet<>();
                    return islandPerimeter(grid, i, j, closed);
                }
            }
        }
        return 0;
    }

    private int islandPerimeter(int[][] grid, int i, int j, Set<Point> closed) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[i].length ||
                grid[i][j] == 0) {
            return 1;
        }
        Point p = new Point(i,j);
        if (grid[i][j] == 1 && !closed.contains(p)) {
            closed.add(p);
            return islandPerimeter(grid,i+1,j,closed) +
                    islandPerimeter(grid,i-1,j,closed) +
                    islandPerimeter(grid,i,j+1,closed) +
                    islandPerimeter(grid,i,j-1,closed);
        } else {
            return 0;
        }
    }
}
