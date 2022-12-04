/*
setein: just select a number and if its under 10k we choose search table
generate: idk
allkeys: just use merge sort (n)
add: find the first key value that is bigger, go back one, add the new key and shift (log n for search), (n for shift)
remove: same thing, shift (log n for search), (n for shift)
getValues: binary search (log n)
nextKey: find the key after this one, prob just binary search and then return i+1 (n)
prevKey: same thing, i-1 (n)
rangeKey: 2 binary searches that return both index and then subtract it. (2 log n)
 */


public class ArraySequence {
    class Node {
        int key;

        //node constructor
        Node(int key){
            this.key = key;
        }
    }

    Node[] NodeArray;

    public void remove(int key){

    }

    public void set(int index, int key){

    }

    public void prev(int key){

    }

    public void next(int key){

    }

    public void get(int key){

    }

    public int indexOf(int key){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i].key == key){
                return i;
            }
        }

        return -1;
    }

    public int atIndex(int index){
        for(int i = 0; i <= index; i++){
            if(i == index) {
                return NodeArray[i].key;
            }
        }
        return -1;
    }


    public int size(){
        return NodeArray.length;
    }

    public boolean isEmpty(){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i] != null){
                return false;
            }
        }

        return true;
    }
}
