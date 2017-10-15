package trees.bt;

import java.util.*;

/*
 * Created by Ajay on 10/15/17.
 *
 *  SOLUTION:
 *
 *  Parse through BFS.
 *      use toVisit queue
 *      use colTracker queue simultaneously
 *
 *  Save the node in a hashmap based on coltracker value
 *
 *  Set columns number based on
 *      left node (col - 1) and
 *      right node (col + 1)
 *
 *  Display as required.
 *
 */


public class VerticalOrderDisplay {

    private List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Queue<Node> toVisit = new LinkedList<>();
        Queue<Integer> colTracker = new LinkedList<>();
        toVisit.add(root);
        colTracker.add(0);

        int minCol = 0;
        int maxCol = 0;

        while (!toVisit.isEmpty()) {
            int col = colTracker.poll();
            Node node = toVisit.poll();

            if (!colMap.containsKey(col)) {
                colMap.put(col, new ArrayList<Integer>());
            }

            colMap.get(col).add(node.key);

            if (node.left != null) {
                toVisit.add(node.left);
                colTracker.add(col - 1);
                minCol = Math.min(minCol, col - 1);
            }

            if (node.right != null) {
                toVisit.add(node.right);
                colTracker.add(col + 1);
                maxCol = Math.max(maxCol, col + 1);
            }

        }

        for (int i = minCol; i <= maxCol; i++) {
            res.add(colMap.get(i));
        }

        return res;
    }


    /* RECURSIVE CODE */

    private List<List<Integer>> verticalOrderRecursive(Node node) {

        TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
        int colTrace = 0;
        verticalOrderRecursive(node, m, colTrace);

        List<List<Integer>> res = new ArrayList<>();
        for ( ArrayList<Integer> list: m.values()){
            res.add(list);
        }
        return res;
    }

    private void verticalOrderRecursive(Node node, TreeMap<Integer,ArrayList<Integer>> m, int colTrace) {
        if (node ==  null) return;

        ArrayList<Integer> list = m.get(colTrace);

        if (list == null){
            list = new ArrayList<>();
            m.put(colTrace, list);
        }
        list.add(node.key);

        verticalOrderRecursive(node.left, m, colTrace - 1);
        verticalOrderRecursive(node.right, m, colTrace + 1);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        n5.left = n10;
        n5.right = n11;

        n6.left = n12;
        n6.right = n13;

        n7.left = n14;
        n7.right = n15;

        List<List<Integer>> result = new VerticalOrderDisplay().verticalOrder(n1);
        //List<List<Integer>> result = new VerticalOrderDisplay().verticalOrderRecursive(n1);

        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


}