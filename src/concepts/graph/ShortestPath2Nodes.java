package concepts.graph;

import java.util.*;

/**
 * Created by Ajay on 8/30/17.
 *
 *  1 ---------> 2
 *  ^ \          |
 *  |  \         |
 *  |   -->3     |
 *  |  /         |
 *  | /          v
 *  4 <--------- 5
 *
 *  2 -> 5 -> 4 -> 3
 *
 * QUESTIONS
 *  Can I assume it to be a acyclic graph.
 *
 * SOLUTION
 *  Use BFS technique.
 *  Iterate over all nodes from the source node and add them to a queue.
 *  Use a hashmap to keep track of visited node.
 *  Finally use the hashmap to backtrace from the dest to src to find the shortest path.
 */

public class ShortestPath2Nodes {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        List<Node> child1 = new ArrayList<Node>();
        n1.nodes = child1;
        child1.add(n2);
        child1.add(n3);

        List<Node> child2 = new ArrayList<Node>();
        n2.nodes = child2;
        child2.add(n5);

        List<Node> child4 = new ArrayList<Node>();
        n4.nodes = child4;
        child4.add(n3);
        child4.add(n1);

        List<Node> child5 = new ArrayList<Node>();
        n5.nodes = child5;
        child5.add(n4);


        List<Node> path = shortestPath(n2, n3);
        for (Node n : path) {
            System.out.println(n.val);
        }
    }

    private static List<Node> shortestPath(Node a, Node b) {
        if (a == null || b == null)
            return null;

        Queue<Node> toVisit = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();

        toVisit.add(a);
        visited.put(a, null);

        while (!toVisit.isEmpty()){
            Node node = toVisit.remove();
            if (node == b) break;
            List<Node> nodes = node.nodes;

            for (Node n : nodes) {
                visited.put(n, node);
                toVisit.add(n);
            }
        }

        if(visited.containsKey(b)){
            Node parent = b;
            List<Node> path = new LinkedList<>();

            while(parent != null){
                path.add(0, parent);
                parent = visited.get(parent);
            }
            return path;
        } else {
            return null;
        }
    }

}

class Node {
    int val;
    List<Node> nodes;

    Node(int val){
        this.val = val;
        nodes = new ArrayList<>();
    }
}
