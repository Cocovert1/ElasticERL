import java.io.FileWriter;
import java.io.IOException;

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

    //Starting point of the tree
    public Node root;
    public String pre, suc;

    //Constructor to build empty BinarySearchTree;
    public BinarySearchTree(){
        root = null;
    }

    public String search(String key){
        root = searchRecursive(root, key);
        if(root != null){
            return key;
        }else{
            return "Key not found";
        }
    }

    public Node searchRecursive(Node root, String key){
        if(root == null || root.key.equals(key)){
            return root;
        }
        if(root.key.compareTo(key) > 0){
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    public void insert(String key){
        root = insertRecursive(root, key);
    }

    //Insert recursively, checking for values
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

    public void remove(String key){
        root = removeRecursive(root, key);
    }

    public Node removeRecursive(Node root, String key){
        if(root == null){
            return root;
        }
        if(key.compareTo(root.key) < 0){
            root.left = removeRecursive(root.left, key);
        }else if(key.compareTo(root.key) > 0){
            root.right = removeRecursive(root.right, key);
        }else{ //1 Child
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

    public String min(Node root){
        String minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public void inorder(){
        inorderRecursive(root);
    }

    public void inorderRecursive(Node root){
        if(root != null){
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    public void findSuccessor(String key){
        findSuccessorRecursive(root, key);
        System.out.println("Pre: " + pre);
        System.out.println("Suc: " + suc);
    }

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
}

