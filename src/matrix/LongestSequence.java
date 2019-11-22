package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ajay on 9/18/17.
 * <p>
 * { 0,   1,   [1], 1, 0},
 * { 1,   0,   [5], 0, 1}
 * {[0], [3],  [4], 0, 1}
 * { 1,  [1],  [0], 1, 0}
 */
public class LongestSequence {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 1, 0}, {1, 0, 5, 0, 1}, {0, 3, 4, 0, 1}, {1, 1, 0, 1, 0}};
        System.out.println(new LongestSequence().findLargestRegion(M));
    }

    private int findLargestRegion(int[][] m) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                List tmp = longestSequence(m, i, j, m[i][j], new ArrayList<>());
                if (tmp != null && tmp.size() > 0) {
                    l.add(tmp);
                }
            }
        }
        System.out.println(l);
        return l.size();
    }

    private ArrayList longestSequence(int[][] m, int i, int j, int value, ArrayList<Integer> list) {
        if (i-1 < 0 || j-1 < 0 || i+1 >= m.length || j+1 >= m[i].length) {
            return null;
        }

        // top
        if(m[i][j-1] < value){
            list.add(m[i][j-1]);
            List l = longestSequence(m, i, j-1, m[i][j-1], list);
            if(l == null){
                return list;
            }
        } else {
            list = new ArrayList<>();
        }

        //bottom
        if(m[i][j+1] < value){
            list.add(m[i][j+1]);
            List l = longestSequence(m, i, j+1, m[i][j+1] , list);
            if(l == null){
                return list;
            }
        } else {
            list = new ArrayList<>();
        }

        // left
        if(m[i-1][j] < value){
            list.add(m[i-1][j]);
            List l = longestSequence(m, i-1, j, m[i-1][j], list);
            if(l == null){
                return list;
            }
        } else {
            list = new ArrayList<>();
        }
        //right
        if(m[i+1][j] < value){
            list.add(m[i+1][j]);
            List l = longestSequence(m, i+1, j, m[i+1][j], list);
            if(l == null){
                return list;
            }
        } else {
            list = new ArrayList<>();
        }

        return list;
    }

}
