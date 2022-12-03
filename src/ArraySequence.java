public class ArraySequence {
    class Node {
        int val;
        int index;

        //node constructor
        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    Node[] NodeArray;

    public void first(){

    }

    public void last(){

    }

    public void prev(){

    }

    public void next(){

    }

    public void get(){

    }

    public int indexOf(int value){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i].val == value){
                return NodeArray[i].index;
            }
        }

        return -1;
    }

    public int atIndex(int index){
        for(int i = 0; i < NodeArray.length; i++){
            if(NodeArray[i].index == index){
                return NodeArray[i].val;
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
