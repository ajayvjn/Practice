package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 12/18/19.
 * <p>
 * { 0,   1,   [1], 1, 0},
 * { 1,   0,   [5], 0, 1}
 * {[0], [3],  [4], 0, 1}
 * { 1,  [1],  [0], 1, 0}
 */
public class ReachAllEdgesWithWater {
    int [][] point = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 1, 0}, {1, 0, 5, 0, 1}, {0, 3, 4, 0, 1}, {1, 1, 0, 1, 0}};
        System.out.println(new ReachAllEdgesWithWater().find(M, 1,2));
    }

    private List<List<Integer>> find(int[][] m, int i,int  j) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        n.add(m[i][j]);
        l = allEdgesList(m,i, j, m[i][j], n);
        return  l;
    }

    private List<List<Integer>> allEdgesList(int[][] m, int i, int j, int value, List<Integer> list) {
        if (i - 1 < 0 || j - 1 < 0 || i + 1 >= m.length || j + 1 >= m[i].length) {
            List<List<Integer>> k = new ArrayList<>();
            k.add(new ArrayList<>(list));
            return k;
        }

        List<List<Integer>> l = new ArrayList<>();

        for (int[] p : point) {
            int x = i+p[0];
            int y = j+p[1];
            if (m[x][y] < value) {
                list.add(m[x][y]);
                l.addAll(allEdgesList(m, x, y, m[x][y], list));
                list.remove(list.size()-1);
            }
        }

        return l;
    }

}
