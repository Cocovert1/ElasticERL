import java.util.Random;

public class BinarySearchTree {
    //Node class to be used by BinarySearchTree, stores values for the tree to hold
    static class Node {
        public String key;
        public Node left;
        public Node right;

        public Node(String key){
            this.key = key;
            left = null;
            right = null;
        }

        public String toString(){
            return this.key;
        }
    }

    //Starting point of the tree + predecessor and successor for prev and next key
    public Node root;
    public String pre, suc;

    //Constructor to build empty BinarySearchTree;
    public BinarySearchTree(){
        root = null;
    }

    //Search method that calls a recursive search function, used to simplify the call and only look for a key instead of using a root
    public String search(String key){
        root = searchRecursive(root, key);
        if(root != null){
            return key;
        }else{
            return "Key does not exist";
        }
    }

    //Recursive search function that looks through a tree and tries finding a matching key
    public Node searchRecursive(Node root, String key){
        if(root == null || root.key.equals(key)){
            return root;
        }
        if(root.key.compareTo(key) > 0){
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    //Insert method to easily insert a key into a tree, omitting duplicates. Does not require root as it calls the recursive insert function
    public void insert(String key){
        root = insertRecursive(root, key);
    }

    //Insert recursively, checking for values and omits duplicates
    public Node insertRecursive(Node root, String key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key.compareTo(root.key) < 0){
            root.left = insertRecursive(root.left, key);
        }else if(key.compareTo(root.key) > 0){
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    //Remove method that finds a matching key and removes it from the tree, calls recursive remove function
    public void remove(String key){
        root = removeRecursive(root, key);
    }

    //Recursive remove function that checks for 3 cases: if the node has 0 children, 1 child or 2 children
    public Node removeRecursive(Node root, String key){
        if(root == null){
            return root;
        }
        if(key.compareTo(root.key) < 0){
            root.left = removeRecursive(root.left, key);
        }else if(key.compareTo(root.key) > 0){
            root.right = removeRecursive(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.key = min(root.right);
            root.right = removeRecursive(root.right, root.key);
        }
        return root;
    }

    //Finds the minimum value of the tree (all the way to the bottom left of the tree)
    public String min(Node root){
        String minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    //Returns all of the keys within the tree in the inorder traversal, calls inorder recursion function
    public void inorder(){
        inorderRecursive(root);
    }

    //Inorder recursion function that goes through all of the nodes (left, root, right) and prints them out
    public void inorderRecursive(Node root){
        if(root != null){
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    //Finds both predecessor and successor of a given key, calls findSuccessor recursive
    public void findSuccessor(String key){
        findSuccessorRecursive(root, key);
    }

    //Recursive findSuccessor function that looks for the key's predecessor and successor, looks at 3 different cases:
    //If the root is null, if the key has a left or right subtree, and if the key is smaller than the node
    public void findSuccessorRecursive(Node root, String key){
        if (root != null) {
            if (root.key.compareTo(key) == 0) {
                if (root.left != null) {
                    Node t = root.left;
                    while (t.right != null) {
                        t = t.right;
                    }
                    pre = t.key;
                }
                if (root.right != null) {
                    Node t = root.right;
                    while (t.left != null) {
                        t = t.left;
                    }
                    suc = t.key;
                }
            } else if (root.key.compareTo(key) > 0) {
                suc = root.key;
                findSuccessorRecursive(root.left, key);
            } else if (root.key.compareTo(key) < 0) {
                pre = root.key;
                findSuccessorRecursive(root.right, key);
            }
        }
    }

    //Generates a number between 10000000 and 99999999 and returns the key
    public String generate(){
        Random rnd = new Random();
        int n = (int) ((Math.random() * (99999999 - 10000000)) + 10000000);
        String key = n + "";
        return key;
    }
}

