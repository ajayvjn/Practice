package trees.bst;

/**
 * Created by Ajay on 10/9/16.
 * https://www.youtube.com/watch?v=UcOxGmj45AA
 */
public class BST {

    Node root;

    /**
     * Add a node into Binary Search Tree
     *
     * @param key
     */
    public void add(int key) {
        Node nodeToAdd = new Node(key);

        if (root == null) {
            root = nodeToAdd;
        } else {
            addNode(root, nodeToAdd);
        }
    }

    private void addNode(Node root, Node nodeToAdd) {
        if (root == null) {
            root = nodeToAdd;
        }
        if (root.key > nodeToAdd.key) {
            if (root.left == null) {
                root.left = nodeToAdd;
            } else {
                addNode(root.left, nodeToAdd);
            }
        } else {
            if (root.right == null) {
                root.right = nodeToAdd;
            } else {
                addNode(root.right, nodeToAdd);
            }
        }
    }

    /**
     * Traverse and display tree using InOrder, PreOrder and PostOrder
     *
     * @param node
     */
    public void traverse(Node node) {
        System.out.println("TRAVERSAL");
        System.out.print("InOrder :\t\t");
        inOrderTraverse(node);
        System.out.print("\nPreOrder :\t\t");
        preOrderTraverse(node);
        System.out.print("\nPostOrder :\t\t");
        postOrderTraverse(node);
    }

    private void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.left);
            System.out.print(" " + focusNode.key);
            inOrderTraverse(focusNode.right);
        }
    }

    private void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(" " + focusNode.key);
            inOrderTraverse(focusNode.left);
            inOrderTraverse(focusNode.right);
        }
    }

    private void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.left);
            inOrderTraverse(focusNode.right);
            System.out.print(" " + focusNode.key);
        }
    }

    /**
     * Find particular node in BST
     *
     * @param key
     * @return Node
     */
    public Node findNode(int key) {
        Node focusNode = root;

        if (focusNode == null)
            return null;

        while (key != focusNode.key) {
            if (key < focusNode.key) {
                if (focusNode.left == null) {
                    return null;
                }
                focusNode = focusNode.left;
            } else {
                if (focusNode.right == null) {
                    return null;
                }
                focusNode = focusNode.right;
            }
        }
        return focusNode;
    }

    /**
     * Delete particular node in BST
     *
     * @param key
     * @return boolean
     */
    public boolean deleteNode(int key) {

        Node focusNode = root;
        Node parent = root;

        boolean isLeftNode = true;

        // Check if the node with input key exists.
        while (key != focusNode.key) {
            parent = focusNode;
            if (key < focusNode.key) {
                isLeftNode = true;
                focusNode = focusNode.left;
            } else {
                isLeftNode = false;
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return false;
            }
        }

        // Check for 3 cases:
        // Case 1: If there is only 1 node in the tree.
        if (focusNode.left == null && focusNode.right == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        }
        // Case 2: If the node to be deleted has only one child.
        else if (focusNode.right == null) {
            if (focusNode == root) {
                root = focusNode.left;
            } else if (isLeftNode) {
                parent.left = focusNode.left;
            } else {
                parent.right = focusNode.left;
            }
            return true;
        } else if (focusNode.left == null) {
            if (focusNode == root) {
                root = focusNode.right;
            } else if (isLeftNode) {
                parent.left = focusNode.right;
            } else {
                parent.right = focusNode.right;
            }
            return true;
        }
        // Case 3: If the node to be deleted has both the child.
        // In this case go one step right and recursively go left until the
        // last node. replace the last node with the node to be deleted.
        else {
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isLeftNode) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
            return true;
        }
    }

    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacementNode = replacedNode;

        // Go one step to right and recursively to the last left node.
        Node focusNode = replacedNode.right;
        while (focusNode != null) {
            replacementParent = replacementNode;
            replacementNode = focusNode;
            focusNode = focusNode.left;
        }

        // Do the following for the last node.
        // 1. Remove the link for the node from parent.
        // 2. Add the children of the replacedNode to the last node.
        if (replacementNode != replacedNode.right) {
            replacementParent.left = null;
            replacementNode.left = replacedNode.left;
            replacementNode.right = replacedNode.right;
        }

        return replacementNode;
    }

    public static void main(String[] args) {
        BST bst = new BST();

        // Add nodes to BST
        bst.add(2);
        bst.add(1);
        bst.add(4);
        bst.add(3);
        bst.add(10);
        bst.add(8);

        // Traverse BST
        bst.traverse(bst.root);

        // Find node with key in BST
        int key = 10;
        Node foundNode = bst.findNode(key);
        if (foundNode != null) {
            System.out.println("\nNode with key=" + key + " found.");
        } else {
            System.out.println("\nNode with key=" + key + " not found.");
        }

        // Delete node in BST
        boolean isDeleted = bst.deleteNode(key);
        if (isDeleted) {
            System.out.println("Node with key=" + key + " deleted.");
        } else {
            System.out.println("Delete failed: Node with key=" + key + " not found.");
        }
        bst.traverse(bst.root);
    }
}

