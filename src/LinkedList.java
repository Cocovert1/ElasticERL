public class LinkedList {
    //node class
    class Node {
        int val;
        Node next;

        //node constructor
        Node(int val){
            this.val = val;
        }
    }

    //creating our node objects
    private Node header;
    private Node trailer;

    //make the new node, add head to next
    public void addFirst(int val){
        if(isEmpty()) {
            header = new Node(val);
            trailer = header;
            return;
        }

        Node newNode = new Node(val);
        newNode.next = header;
        header = newNode;
    }

    //make the new node, add the node to the next of the tail node
    public void addLast(int val){
        if(isEmpty()) {
            header = new Node(val);
            trailer = header;
            return;
        }

        Node newNode = new Node(val);
        trailer.next = newNode;
        trailer = newNode;
    }

    //move to the position before where we want to insert, and fix the pointers
    public void add(int pos, int val){
        //validation
        if( pos == 1 ){
            addFirst(val);
            return;
        }

        Node current = header;
        int count = 1;

        while(count < pos-1) {
            count++;
            current = current.next;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    //make the header point to the next and remove all the pointers the first had
    public int deleteFirst(){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }

        Node current = header;
        header = header.next;
        current.next = null;

        if(isEmpty()) {
            trailer = null;
        }

        return current.val;
    }

    //move to the before last node and last node and remove the pointers
    public int deleteLast() {
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }

        if(header == trailer) {
            int val = header.val;
            header = null;
            trailer = null;
            return val;
        }

        Node current = header;
        Node prev = null;

        while (current.next != null){
            prev = current;
            current = current.next;
        }

        prev.next = null;
        trailer = prev;
        return current.val;
    }

    //move to the position just before, and jump the pointer to the current.next
    public int delete(int pos){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }

        if(pos == 1) {
            deleteFirst();
        }

        Node current = header;
        Node previous = null;
        int count = 1;

        while(count < pos) {
            count++;
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        current.next = null;
        return current.val;
    }

    //searches for a value in the linked list
    public boolean search(int val){
        Node current = header;
        while(current != null){
            if(val == current.val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return header == null ;
    }


    //prints the contents of the linked list
    public void print(){
        Node current = header;
        while(current != null){
            System.out.print(current.val +" -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
