/*
This is our search table. This is our data Structure for small data sets.
 */

import java.util.Random;

public class ArraySequence {
    //creating the node class
    class Node {
         String key;
         int value;

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        //node constructor
        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }


    }

    Node[] NodeArray;

    //inserts the original data in the node array
    public void initialInsert(String[] sortedArr){
        NodeArray = new Node[sortedArr.length];
        for(int i = 0; i < sortedArr.length; i++){
            NodeArray[i] = new Node(sortedArr[i], 0);
        }
    }

    //removes the key from the sequence
    public void remove(String key){
        //finds the key
        BinarySearchAlgorithm search = new BinarySearchAlgorithm();
        if(search.binarySearch(NodeArray, key) == -1){
            System.out.println("Key does not exist");
            return;
        }

        int i;
        for(i = 0; i < NodeArray.length; i++){
            if(NodeArray[i].key.compareTo(key) == 0){
                break;
            }
        }

        for(int k = i; k < NodeArray.length; k++){
            if(NodeArray[k+1] == null){
                NodeArray[k] = null;
                break;
            }
            if(k == NodeArray.length-1){
                break;
            }
            NodeArray[k] = new Node(NodeArray[k+1].key, 0);
        }
    }

    //adds a key to the sequence
    public void add(String key){
        //checks if key already exists
        BinarySearchAlgorithm search = new BinarySearchAlgorithm();
        if(search.binarySearch(NodeArray, key) != -1){
            System.out.println("Key already exists");
            return;
        }

        //amortization
        if(isFull()) {
            Node[] newNodeArray = new Node[2 * NodeArray.length];
            for (int i = 0; i < NodeArray.length; i++) {
                newNodeArray[i] = NodeArray[i];
            }

            NodeArray = newNodeArray;
        }

        int i;
        for(i = 0; i < NodeArray.length; i++){
            if(NodeArray[i] == null){
                break;
            }
            if(NodeArray[i].key.compareTo(key) > 0){
                break;
            }
        }

        //shifts
        for(int k = NodeArray.length; k >= i; k--){
            if(k == i){
                NodeArray[k] = new Node(key, 0);
                break;
            }else {
                if(NodeArray[k-1] == null){
                    continue;
                }
                NodeArray[k] = new Node(NodeArray[k-1].key, 0);
            }
        }
    }

    //finds the previous key in the sequence
    public String prev(String key){
        BinarySearchAlgorithm binSearch = new BinarySearchAlgorithm();
        int position = binSearch.binarySearch(NodeArray, key);
        if((position-1) < 0){
            return null;
        }
        return NodeArray[position-1].key;
    }

    //finds the next key in the sequence
    public String next(String key){
        BinarySearchAlgorithm binSearch = new BinarySearchAlgorithm();
        int position = binSearch.binarySearch(NodeArray, key);
        if(NodeArray[position+1] == null){
            return null;
        }
        return NodeArray[position+1].key;
    }

    //returns the index of the string
    public int get(String key){
        BinarySearchAlgorithm binSearch = new BinarySearchAlgorithm();
        int position = binSearch.binarySearch(NodeArray, key);
        return position;
    }

    //checks if the sequence is full
    public boolean isFull(){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i] == null){
                return false;
            }
        }
        return true;
    }

    //generates a random key and checks if it can be inputted
    public void generate(){
        Random rnd = new Random();
        BinarySearchAlgorithm search = new BinarySearchAlgorithm();
        int n = 100000 + rnd.nextInt(99999999);
        String key = n + "";

        if(search.binarySearch(NodeArray, key) != -1){
            System.out.println("Key already exists");
            generate();
        } else {
            add(key);
        }


    }
}
