/*
setein: just select a number and if its under 10k we choose search table
generate: idk
allkeys: just return the array
add: find the first key value that is bigger, go back one, add the new key and shift (log n for search), (n for shift)
remove: same thing, shift (log n for search), (n for shift)
getValues: binary search (log n)
nextKey: find the key after this one, prob just binary search and then return i+1 (n)
prevKey: same thing, i-1 (n)
rangeKey: 2 binary searches that return both index and then subtract it. (log n)
 */

import java.util.Random;

public class ArraySequence {
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

    // n
    public void initialInsert(String[] sortedArr){
        NodeArray = new Node[sortedArr.length];
        for(int i = 0; i < sortedArr.length; i++){
            NodeArray[i] = new Node(sortedArr[i], 0);
        }
    }

    // n
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

    // n
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

    // log n
    public String prev(String key){
        BinarySearchAlgorithm binSearch = new BinarySearchAlgorithm();
        int position = binSearch.binarySearch(NodeArray, key);
        if((position-1) < 0){
            return null;
        }
        return NodeArray[position-1].key;
    }

    // log n
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


    //returns the key at index
    public String atIndex(int index){
        for(int i = 0; i <= index; i++){
            if(i == index) {
                return NodeArray[i].key;
            }
        }
        return null;
    }


    public int size(){
        return NodeArray.length;
    }

    //checks if empty
    public boolean isEmpty(){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i] != null){
                return false;
            }
        }

        return true;
    }

    public boolean isFull(){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i] == null){
                return false;
            }
        }
        return true;
    }

    // n
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
