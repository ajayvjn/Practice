package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    // without extra memory
    public RandomListNode copyRandomList1(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode newList = pseudoHead;
        RandomListNode copyNode;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copyNode = iter.next;
            newList.next = copyNode;
            newList = copyNode;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    // with extra memory
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

}



class RandomListNode{
    int val;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int val){
        this.val = val;
    }
}
